package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort the array to enable the two-pointer approach and simplify deduplication.
        Arrays.sort(nums);
        // Iterate through the array, leaving at least 2 elements for the two pointers.
        for (int i = 0; i < nums.length - 2; i++) {
            // Pruning: If the anchor number is greater than 0, the sum cannot be 0.
            if (nums[i] > 0) {
                break;
            }
            // Deduplication for the outer loop: Skip identical anchor values to prevent duplicate triplets.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // Initialize two pointers.
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    // Sum is too small; move the left pointer to the right to increase the sum.
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    // Target sum found; add the triplet to the result list.
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Deduplication for the inner loop: Skip identical left pointer values.
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Deduplication for the inner loop: Skip identical right pointer values.
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // Move both pointers inward to search for the next potential triplet.
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}
