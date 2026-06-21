package leetcode.editor.en;

//Given an array of distinct integers candidates and a target integer target, 
//return a list of all unique combinations of candidates where the chosen numbers 
//sum to target. You may return the combinations in any order. 
//
// The same number may be chosen from candidates an unlimited number of times. 
//Two combinations are unique if the frequency of at least one of the chosen 
//numbers is different. 
//
// The test cases are generated such that the number of unique combinations 
//that sum up to target is less than 150 combinations for the given input. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [2,3,6,7], target = 7
//Output: [[2,2,3],[7]]
//Explanation:
//2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple 
//times.
//7 is a candidate, and 7 = 7.
//These are the only two combinations.
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,3,5], target = 8
//Output: [[2,2,2,2],[2,3,3],[3,5]]
// 
//
// Example 3: 
//
// 
//Input: candidates = [2], target = 1
//Output: []
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 30 
// 2 <= candidates[i] <= 40 
// All elements of candidates are distinct. 
// 1 <= target <= 40 
// 
//
// Related Topics Array Backtracking 👍 21114 👎 543


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    // Time Complexity: O( )
    // Space Complexity: O( )
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Sort the array first to enable early stopping
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        // Edge case: if the smallest number is already greater than the target, return immediately
        if (candidates[0] > target){
            return result;
        }
        // Start backtracking: pass the result list, an empty path list, initial sum 0, and starting index 0
        backtrack(result, new ArrayList<>(), 0, candidates, target, 0);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int currentSum, int[] candidates, int target, int startIndex){
        // Base case: if the sum matches the target, add a deep copy of the current path to the result
        if (currentSum == target){
            result.add(new ArrayList<>(currentList));
            return;
        }
        // Iterate through the array starting from 'startIndex' to avoid duplicate combinations
        for (int i = startIndex; i < candidates.length; i++){
            // Pruning: if adding the current number exceeds the target, stop exploring this branch
            // This relies on the array being sorted beforehand
            if (currentSum + candidates[i] >target){
                break;
            }
            // Make a choice: add the current number to the path and update the sum
            currentSum += candidates[i];
            currentList.add(candidates[i]);
            // Recurse: pass 'i' as the startIndex to allow unlimited reuse of the current element
            backtrack(result, currentList, currentSum, candidates, target, i);
            // Backtrack: undo the choice to explore other possibilities in the loop
            currentSum -= candidates[i];
            currentList.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}