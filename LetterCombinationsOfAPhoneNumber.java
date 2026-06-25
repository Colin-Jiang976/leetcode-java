package leetcode.editor.en;

//Given a string containing digits from 2-9 inclusive, return all possible 
//letter combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digits to letters (just like on the telephone buttons) is given 
//below. Note that 1 does not map to any letters. 
// 
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 1 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
//
// Related Topics Hash Table String Backtracking 👍 21112 👎 1138


public class LetterCombinationsOfAPhoneNumber {
    // Time Complexity: O( )
    // Space Complexity: O( )
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        // Base case: if the input is empty, return an empty list immediately
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        // 1. Setup the mapping using an array for O(1) index access
        String[] phoneMap = {
                "",     // 0
                "",     // 1
                "abc",  // 2
                "def",  // 3
                "ghi",  // 4
                "jkl",  // 5
                "mno",  // 6
                "pqrs", // 7
                "tuv",  // 8
                "wxyz"  // 9
        };
        List<String> result = new ArrayList<>();
        // Trigger the backtracking process
        backtrack(result, new StringBuilder(), digits, 0, phoneMap);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder currentPath, String digits, int index, String[] phoneMap) {

        // 2. Base Case: if the current path length equals the digits length, a combination is formed
        if (index == digits.length()) {
            result.add(currentPath.toString());
            return;
        }
        // 3. Get the choices for the current digit
        char digitChar = digits.charAt(index);
        // Convert char to integer index using ASCII offset magic
        int mapIndex = digitChar - '0';
        String possibleLetters = phoneMap[mapIndex];

        // 4. Explore all possible letters for this digit
        for (int i = 0; i < possibleLetters.length(); i++) {
            char letter = possibleLetters.charAt(i);
            // Make a choice: append the letter
            currentPath.append(letter);
            // Move to the next digit (index + 1)
            backtrack(result, currentPath, digits, index + 1, phoneMap);
            // Undo the choice (Backtracking): remove the last appended letter to explore other branches
            currentPath.deleteCharAt(currentPath.length() - 1);
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}