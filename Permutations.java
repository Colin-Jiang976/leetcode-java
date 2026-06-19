package leetcode.editor.en;

//Given an array nums of distinct integers, return all the possible 
//permutations. You can return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
// Example 2: 
// Input: nums = [0,1]
//Output: [[0,1],[1,0]]
// 
// Example 3: 
// Input: nums = [1]
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// All the integers of nums are unique. 
// 
//
// Related Topics Array Backtracking 👍 20965 👎 386


import java.util.ArrayList;
import java.util.List;

public class Permutations {
    // Time Complexity: O( )
    // Space Complexity: O( )
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // Initialize the final result list to store all valid permutations
        List<List<Integer>> result = new ArrayList<>();
        // Initialize the list to keep track of the current permutation path
        List<Integer> currentPath = new ArrayList<>();

        // Array to track used elements to avoid duplicates in the current path (O(1) lookup)
        boolean[] used = new boolean[nums.length];
        // Start the backtracking process
        backtrack(result, currentPath, nums, used);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentPath, int[] nums, boolean[] used){

        // Base Case: If the current path's size equals nums.length, a full permutation is formed
        if (currentPath.size() == nums.length){
            // Deep copy the current path to prevent modification during backtracking
            result.add(new ArrayList<>(currentPath));
            return;
        }
        // Iterate through all numbers to build permutations
        for (int i = 0; i < nums.length; i++){
            if (used[i]){
                continue;
            }
            // 1. Make a choice
            currentPath.add(nums[i]);// Append the number to the path
            used[i] = true;// Mark the number as used
            // 2. Recurse to the next level
            backtrack( result, currentPath, nums, used);
            // 3. Undo the choice (Backtrack)
            currentPath.removeLast();// Remove the last added number (Java 21+ feature)
            used[i] = false;// Reset the used state for the next iteration
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}