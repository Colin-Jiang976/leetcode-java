package leetcode.editor.en;

//Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be 
//validated according to the following rules: 
//
// 
// Each row must contain the digits 1-9 without repetition. 
// Each column must contain the digits 1-9 without repetition. 
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 
//without repetition. 
// 
//
// Note: 
//
// 
// A Sudoku board (partially filled) could be valid but is not necessarily 
//solvable. 
// Only the filled cells need to be validated according to the mentioned rules. 
//
// 
//
// 
// Example 1: 
// 
// 
//Input: board = 
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: board = 
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//Output: false
//Explanation: Same as Example 1, except with the 5 in the top left corner 
//being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is 
//invalid.
// 
//
// 
// Constraints: 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] is a digit 1-9 or '.'. 
// 
//
// Related Topics Array Hash Table Matrix 👍 12598 👎 1270


public class ValidSudoku {
    // Time Complexity: O( )
    // Space Complexity: O( )
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Initialize 2D boolean arrays as tracking ledgers for rows, columns, and 3x3 sub-boxes
        // Default value in Java boolean array is false (indicating the digit has not been seen yet)
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        // Iterate through every cell in the 9x9 board
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char num = board[row][col];
                // Skip empty cells to minimize processing overhead
                if (num == '.') {
                    continue;
                }
                // Map the character '1'-'9' to a zero-based integer index 0-8
                int digit = num - '1';

                // Calculate the 1D index (0-8) for the 3x3 sub-box corresponding to current coordinates
                int boxIndex = (row / 3) * 3 + (col / 3);

                // Audit check: If the digit already exists in the current row, column, or sub-box, it's invalid
                if (rows[row][digit] || cols[col][digit] || boxes[boxIndex][digit]) {
                    return false;
                }

                // Record the digit's presence in our tracking ledgers
                rows[row][digit] = true;
                cols[col][digit] = true;
                boxes[boxIndex][digit] = true;
            }
        }
        // Return true if the entire board passes the audit without any conflicts
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}