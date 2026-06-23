package leetcode.editor.en;

//Given a linked list, swap every two adjacent nodes and return its head. You 
//must solve the problem without modifying the values in the list's nodes (i.e., 
//only nodes themselves may be changed.) 
//
// 
// Example 1: 
//
// 
// Input: head = [1,2,3,4] 
// 
//
// Output: [2,1,4,3] 
//
// Explanation: 
//
// 
//
// Example 2: 
//
// 
// Input: head = [] 
// 
//
// Output: [] 
//
// Example 3: 
//
// 
// Input: head = [1] 
// 
//
// Output: [1] 
//
// Example 4: 
//
// 
// Input: head = [1,2,3] 
// 
//
// Output: [2,1,3] 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 100]. 
// 0 <= Node.val <= 100 
// 
//
// Related Topics Linked List Recursion 👍 13232 👎 519


public class SwapNodesInPairs {
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
    public ListNode swapPairs(ListNode head) {
        // Base Case: If the list is empty or has only one node left, no swap is needed.
        if (head == null || head.next == null) {
            return head;
        }

        // Identify the second node, which will become the new head of this pair.
        ListNode secondNode = head.next;

        // Recursive Step:
        // 1. The original first node (head) connects to the result of the swapped remaining list.
        head.next = swapPairs(head.next.next);

        // 2. The second node moves to the front, pointing back to the original first node.
        secondNode.next = head;

        // Return the new head of this swapped pair to the previous level.
        return secondNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}