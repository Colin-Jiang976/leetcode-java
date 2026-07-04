package leetcode.editor.en;

//Given a collection of numbers, nums, that might contain duplicates, return 
//all possible unique permutations in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2]
//Output:
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics Array Backtracking Sorting 👍 9210 👎 163


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsIi {
    // Time Complexity: O( )
    // Space Complexity: O( )
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Container to store the final distinct permutations
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        // Sort the array to group identical elements together for $O(1)$ duplicate detection
        Arrays.sort(nums);
        // State machine array to track which elements are currently used in the path
        boolean[] used = new boolean[nums.length];

        backtrack(nums, new ArrayList<>(), used);
        return result;
    }
    private void backtrack(int[] nums, List<Integer> path, boolean[] used) {

        // Base Case: A valid permutation is formed when the path length equals the array length
        if (path.size() == nums.length) {
            // Create a deep copy of the current path to prevent subsequent rollbacks from altering it
            result.add(new ArrayList<>(path));
            return;
        }

        // Iterate through all possible choices at the current decision tree level
        for (int i = 0; i < nums.length; i++) {
            // Base interception: Skip if the element at this index is already used in the current path
            if (used[i]) {
                continue;
            }

            // Core Pruning Logic (Deduplication):
            // i > 0: Prevent ArrayIndexOutOfBoundsException
            // nums[i] == nums[i - 1]: Identify duplicate elements
            // !used[i - 1]: If the previous identical element was just rolled back (unused),
            // exploring the current one would result in a redundant parallel branch. Prune it.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                 continue;
             }

            // Make choice: Advance the state machine
            path.add(nums[i]);
            used[i] = true;
            // Recursion: Drill down to the next level of the decision tree
            backtrack(nums, path, used);
            // Undo choice (Rollback): Clear sunk cost and restore the state for the next iteration
            path.removeLast();
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}