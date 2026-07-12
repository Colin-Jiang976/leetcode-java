package leetcode.editor.en;

//Given an array of integers nums sorted in non-decreasing order, find the 
//starting and ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// 
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// 
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums is a non-decreasing array. 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics Array Binary Search 👍 23497 👎 655


public class FindFirstAndLastPositionOfElementInSortedArray {
    // Time Complexity: O( )
    // Space Complexity: O( )
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Handle edge case: return default values if the array is null or empty
        // This prevents NullPointerException and avoids unnecessary processing
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int leftBoundary = -1;
        int rightBoundary = -1;
        // --- Phase 1: Find the First Position (Lower Bound) ---
        int left = 0;
        int right = nums.length - 1;

        while (left<=right){
            // Use subtraction to prevent potential integer overflow
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                leftBoundary = mid;// Record the candidate index
                right = mid - 1;// Squeeze the right pointer to find earlier occurrences
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // --- Phase 2: Find the Last Position (Upper Bound) ---
        // Critical: Reset pointers for the second independent binary search
        left = 0;
        right = nums.length - 1;

        while (left<=right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                rightBoundary = mid;// Record the candidate index
                left = mid + 1;// Squeeze the left pointer to find later occurrences
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // Return the final bounded range
        return new int[]{leftBoundary, rightBoundary};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}