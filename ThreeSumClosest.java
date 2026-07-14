package leetcode.editor.en;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array to establish monotonicity, enabling the two-pointer approach.
        Arrays.sort(nums);
        // Initialize the baseline with the sum of the first three elements to avoid integer overflow.
        int closestSum = nums[0] + nums[1] + nums[2];
        // Iterate through the array, fixing one element as the anchor.
        for (int i = 0; i < nums.length - 2; i++) {

            // Define the search space using left and right pointers.
            int left = i + 1;
            int right = nums.length - 1;

            // Shrink the search space from both ends.
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // Update the global optimum if a smaller absolute difference is found.
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // Pointer movement logic based on current sum vs target.
                if (currentSum < target) {
                    left++;// Need a larger value to approach the target.
                } else if (currentSum > target) {
                    right--;// Need a smaller value to approach the target.
                } else {
                    // Early return for optimal match (Zero difference).
                    return currentSum;
                }
            }
        }
        return closestSum;
    }
}
