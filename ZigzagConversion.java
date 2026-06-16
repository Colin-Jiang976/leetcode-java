package leetcode.editor.en;

//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number 
//of rows like this: (you may want to display this pattern in a fixed font for 
//better legibility) 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R
// 
//
// And then read line by line: "PAHNAPLSIIGYIR" 
//
// Write the code that will take a string and make this conversion given a 
//number of rows: 
//
// 
//string convert(string s, int numRows);
// 
//
// 
// Example 1: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
// 
//
// Example 2: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// Example 3: 
//
// 
//Input: s = "A", numRows = 1
//Output: "A"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of English letters (lower-case and upper-case), ',' and '.'. 
// 1 <= numRows <= 1000 
// 
//
// Related Topics String 👍 9422 👎 15960


public class ZigzagConversion {
    // Time Complexity: O( )
    // Space Complexity: O( )
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public String convert(String s, int numRows) {
            // Base case: If only 1 row, no zigzag is possible, return original string
            if (numRows == 1) return s;

            // Step 1: Initialize an array of StringBuilders (baskets for each row)
            StringBuilder[] baskets = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
                baskets[i] = new StringBuilder();
            }

            // Step 2: Set up the state machine variables (current floor and elevator direction)
            int currentRow = 0;
            int direction = 1; // 1 represents moving down, -1 represents moving up

            // Step 3: Traverse the string and simulate the zigzag movement
            for (int i = 0; i < s.length(); i++) {
                // Append the current character to the corresponding row's basket
                baskets[currentRow].append(s.charAt(i));

                // State transition: Check if we hit the top or bottom boundary
                if (currentRow == 0 || currentRow == numRows - 1) {
                    // Explicitly set direction to prevent any logical inversion bugs
                    if (currentRow == 0) {
                        direction = 1;  // Force direction to move down
                    } else if (currentRow == numRows - 1) {
                        direction = -1; // Force direction to move up
                    }
                }

                // Move the elevator one step in the current direction
                currentRow = currentRow + direction;
            }

            // Step 4: Concatenate all row baskets into the final result string
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                result.append(baskets[i]);
            }

            return result.toString();
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}