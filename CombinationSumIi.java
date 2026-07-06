package leetcode.editor.en;

//Given a collection of candidate numbers (candidates) and a target number (
//target), find all unique combinations in candidates where the candidate numbers sum 
//to target. 
//
// Each number in candidates may only be used once in the combination. 
//
// Note: The solution set must not contain duplicate combinations. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [10,1,2,7,6,1,5], target = 8
//Output: 
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,5,2,1,2], target = 5
//Output: 
//[
//[1,2,2],
//[5]
//]
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics Array Backtracking 👍 12372 👎 392


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIi {
    // Time Complexity: O( )
    // Space Complexity: O( )
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Global variable to store the final valid combinations
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Step 1: Sort the array to group duplicates physically.
        // This is the prerequisite for O(1) deduplication and early termination.
        Arrays.sort(candidates);
        // Edge cases: empty array or the smallest element already exceeds target
        if (candidates == null || candidates.length == 0 || candidates[0] > target) {
            return result;
        }
        // Initialize the backtracking process
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int[] candidates, int remainTarget, int startIndex, List<Integer> currentPath, List<List<Integer>> result){
        // Base Case: The target has been successfully reduced to 0. A valid path is found.
        if (remainTarget == 0) {
            // Create a deep copy of the current state and add it to the result set
            result.add(new ArrayList<>(currentPath));
            return;
        }
        // Iterate through the available candidates starting from the current index
        for (int i = startIndex; i < candidates.length; i++) {
            // Pruning 1 (Deduplication): Skip elements that are identical to the previous one at the same tree level.
            // i > startIndex ensures we only deduplicate siblings, not parent-child nodes.
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // Pruning 2 (Early Termination): Because the array is sorted, if the current element
            // exceeds the remaining target, all subsequent elements will also exceed it.
            // Break the loop to maximize execution efficiency (ROI).
            if (remainTarget - candidates[i] < 0) {
                break;
            }
            // State Progression: Add the current candidate to the path
            currentPath.add(candidates[i]);
            // Recursive Call: Move to the next level (i + 1) because elements cannot be reused.
            backtrack(candidates, remainTarget - candidates[i], i + 1, currentPath, result);
            // State Reversal (Backtracking): Remove the last added element to explore other branches
            currentPath.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}