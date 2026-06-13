package leetcode.editor.en;

//You are given two non-empty linked lists representing two non-negative 
//integers. The digits are stored in reverse order, and each of their nodes contains a 
//single digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the 
//number 0 itself. 
//
// 
// Example 1: 
// 
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have 
//leading zeros. 
// 
//
// Related Topics Linked List Math Recursion 👍 36909 👎 7269


public class AddTwoNumbers {
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Create a dummy node to serve as the starting point of the result list
        ListNode dummy = new ListNode(0);
        // 'current' pointer acts as the write head to build the new list
        ListNode current = dummy;
        // Initialize the carry value to 0
        int carry = 0;

        // Continue the loop if there are still nodes in l1 or l2, or if there's a leftover carry
        while (l1 != null || l2 != null || carry != 0) {

            // Safely extract values: use 0 if the node is null (already reached the end)
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // Calculate the total sum of the current digits and the carry from the previous step
            int sum = val1 + val2 + carry;

            // Update the carry for the next iteration (e.g., 15 / 10 = 1)
            carry = sum / 10;

            // Create a new node with the remainder (e.g., 15 % 10 = 5) and append it to the list
            current.next = new ListNode(sum % 10);

            // Move the write head to the newly created node
            current = current.next;

            // Safely advance the pointers of l1 and l2 to their next nodes
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // Return the actual head of the resulting linked list (skipping the dummy node)
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}