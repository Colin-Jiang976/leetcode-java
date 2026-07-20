package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        // Edge case: if array has fewer than 4 elements, return empty list
        if (nums == null || n < 4) return result;
        // Step 1: Sort the array to enable two pointers and deduplication
        Arrays.sort(nums);
        // Step 2: First loop to fix the first number 'a'
        for (int i = 0; i < n - 3; i++) {
            // Deduplication for 'a': skip if it's the same as the previous one
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // Pruning : if the 4 smallest numbers exceed target, stop completely
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            // Pruning: if 'a' plus the 3 largest numbers are still less than target, skip this 'a'
            if ((long) nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) continue;
            // Step 3: Second loop to fix the second number 'b'
            for (int j = i + 1; j < n - 2; j++) {
                // Deduplication for 'b': skip if it's the same as the previous one in the same loop level
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                // Inner pruning
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if ((long) nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) continue;
                // Step 4: Two pointers approach to find 'c' and 'd'
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    // Use long to prevent integer overflow
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        // Match found, add to result
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // Deduplication for 'c' and 'd'
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        // Move both pointers inward
                        left++;
                        right--;

                    } else if (sum < target) {
                        // Sum is too small, move left pointer to increase sum
                        left++;
                    } else {
                        // Sum is too large, move right pointer to decrease sum
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
