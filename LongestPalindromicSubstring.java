package leetcode.editor.en;

//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
//
// Related Topics Two Pointers String Dynamic Programming 👍 32768 👎 2016


public class LongestPalindromicSubstring {
    // Time Complexity: O( )
    // Space Complexity: O( )
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public String longestPalindrome(String s) {
            // Edge case: empty string or null
            if (s == null || s.length() < 1) {
                return "";
            }

            int start = 0;
            int maxLength = 0;

            // Traverse each character to treat it as a potential center
            for (int i = 0; i < s.length(); i++) {
                // Task A: Odd length palindromes (single character center)
                int len1 = expandAroundCenter(s, i, i);
                // Task B: Even length palindromes (gap between characters as center)
                int len2 = expandAroundCenter(s, i, i + 1);

                // Get the maximum length found from both expansions
                int len = Math.max(len1, len2);

                // If a longer palindrome is found, update the tracker
                if (len > maxLength) {
                    // Calculate the starting index using the integer division trick
                    start = i - (len - 1) / 2;
                    maxLength = len;
                }
            }

            // Extract and return the valid substring
            return s.substring(start, start + maxLength);
        }

        // Helper method: Expand outwards while characters match
        private int expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            // Return the length of the valid palindrome (right - left - 1)
            return right - left - 1;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}