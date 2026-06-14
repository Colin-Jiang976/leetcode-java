package leetcode.editor.en;

//Given a string s, find the length of the longest substring without duplicate 
//characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3. Note that "bca" and 
//"cab" are also correct answers.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of English letters, digits, symbols and spaces. 
// 
//
// Related Topics Hash Table String Sliding Window 👍 45207 👎 2222


import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    // Time Complexity: O( )
    // Space Complexity: O( )
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int lengthOfLongestSubstring(String s) {
            // Use a HashSet to store unique characters in the current sliding window.
            // It provides O(1) time complexity for lookups and insertions.
            HashSet<Character> set = new HashSet<>();

            // 'left' pointer acts as the trailing edge (slow pointer) of the sliding window.
            int left = 0;

            // 'maxLength' keeps track of the longest valid substring found so far.
            int maxLength = 0;

            // 'right' pointer acts as the leading edge (fast pointer), expanding the window.
            for (int right = 0; right < s.length(); right++) {
                // If the newly encountered character is already in the set, a collision occurs.
                // We actively shrink the window from the left until the duplicate character is removed.
                while (set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }

                // Add the current character to the set as it is now guaranteed to be unique.
                set.add(s.charAt(right));

                // Update the maximum length recorded so far with the current window size.
                maxLength = Math.max(maxLength, set.size());
            }

            // Return the historical maximum length of the substring.
            return maxLength;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}