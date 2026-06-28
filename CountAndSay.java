package leetcode.editor.en;

//The count-and-say sequence is a sequence of digit strings defined by the 
//recursive formula: 
//
// 
// countAndSay(1) = "1" 
// countAndSay(n) is the run-length encoding of countAndSay(n - 1). 
// 
//
// Run-length encoding (RLE) is a string compression method that works by 
//replacing each maximal group of consecutive identical characters with the 
//concatenation of the length of the group followed by the character itself. For example, to 
//compress the string "3322251" we replace "33" with "23", replace "222" with "32",
// replace "5" with "15", and replace "1" with "11". Thus the compressed string 
//becomes "23321511". 
//
// Given a positive integer n, return the nᵗʰ element of the count-and-say 
//sequence. 
//
// 
// Example 1: 
//
// 
// Input: n = 4 
// 
//
// Output: "1211" 
//
// Explanation: 
//
// 
//countAndSay(1) = "1"
//countAndSay(2) = RLE of "1" = "11"
//countAndSay(3) = RLE of "11" = "21"
//countAndSay(4) = RLE of "21" = "1211"
// 
//
//
// Example 2: 
//
// 
// Input: n = 1 
// 
//
// Output: "1" 
//
// Explanation: 
//
// This is the base case. 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 30 
// 
//
// 
//Follow up: Could you solve it iteratively?
//
// Related Topics String 👍 5163 👎 9114


public class CountAndSay {
    // Time Complexity: O( )
    // Space Complexity: O( )
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String countAndSay(int n) {
        // Base case: the sequence always starts with "1"
        if (n == 1) return "1";
        // Initial state for n = 1
        String result = "1";
        // Outer loop: iteratively generate the sequence from step 2 up to n
        for (int i = 2; i <= n; i++){
            // StringBuilder is used for efficient string concatenation in loops
            StringBuilder currentLine = new StringBuilder();
            int count = 1;
            // Inner loop: read the 'result' string from the previous step
            for (int j = 0; j < result.length(); j++){
                char say = result.charAt(j);
                // Core logic:
                // 1. If it's the last character (j == result.length() - 1)
                // 2. OR if the current character is different from the next one
                // We append the count and the character, then reset count to 1.
                if (j == result.length() - 1 || say != result.charAt(j + 1)) {
                    currentLine.append(count).append(say);
                    count = 1;
                } else {
                    // If the next character is identical, increment the count
                    count++;
                }
            }
            // Update the result for the next iteration
            result = currentLine.toString();
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}