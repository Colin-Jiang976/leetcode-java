package leetcode.editor.en;

//Given n pairs of parentheses, write a function to generate all combinations 
//of well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// 
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics String Dynamic Programming Backtracking 👍 23375 👎 1088


public class GenerateParentheses {
    // Time Complexity: O( )
    // Space Complexity: O( )
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // API Endpoint exposed to the caller
    public List<String> generateParenthesis(int n) {
        // Initialize the global result pool to store all valid combinations
        List<String> result = new ArrayList<>();

        // Trigger the backtracking worker with initial state:
        // empty path, 0 used left parentheses, 0 used right parentheses, and quota n
        backtrack(result, new StringBuilder(), 0, 0, n);

        return result;
    }

        // Helper method for recursive backtracking
        private void backtrack(List<String> result, StringBuilder currentPath, int left_count, int right_count, int n) {

            // 1. Base Case: If the number of right parentheses reaches 'n',
            // a valid sequence is completed. Add it to the result pool.
            if (right_count == n) {
                result.add(currentPath.toString());
                return; // Exit the current stack frame and return to the previous level
            }

            // 2. Rule A (Add Left): We can add a '(' as long as we haven't reached the limit 'n'
            if (left_count < n) {
                currentPath.append("("); // Make a choice
                // Recursively explore this branch with updated left_count
                backtrack(result, currentPath, left_count + 1, right_count, n);
                currentPath.deleteCharAt(currentPath.length() - 1); // Undo the choice (Backtrack)
            }

            // 3. Rule B (Add Right): We can only add a ')' if there are unmatched '(' available
            if (left_count > right_count) {
                currentPath.append(")"); // Make a choice
                // Recursively explore this branch with updated right_count
                backtrack(result, currentPath, left_count, right_count + 1, n);
                currentPath.deleteCharAt(currentPath.length() - 1); // Undo the choice (Backtrack)
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}