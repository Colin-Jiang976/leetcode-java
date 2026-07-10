package leetcode.editor.en;

//Given the head of a linked list, remove the nᵗʰ node from the end of the list 
//and return its head. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1], n = 1
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1,2], n = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is sz. 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
// Follow up: Could you do this in one pass? 
//
// Related Topics Linked List Two Pointers 👍 21424 👎 915


public class RemoveNthNodeFromEndOfList {
    // Time Complexity: O( )
    // Space Complexity: O( )
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node pointing to the head to handle edge cases
        // cleanly (e.g., when the head node itself needs to be removed).
        ListNode dummy = new ListNode(0, head);

        // Initialize two pointers (fast and slow) at the dummy node.
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move the fast pointer n + 1 steps ahead.
        // This creates the required gap between fast and slow pointers.
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Traverse the linked list with both pointers at the same speed.
        // When fast reaches the end (null), slow will be positioned exactly
        // one node before the target node to be deleted.
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Unlink the target node by skipping it in the next pointer reference.
        slow.next = slow.next.next;

        // Return the modified list starting from the actual head.
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}