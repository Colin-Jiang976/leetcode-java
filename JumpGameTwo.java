package leetcode.editor.en;

class Solution {
    public int jump(int[] nums) {
        // Number of jumps needed to reach the end.
        int jumps = 0;
        // The maximum index we can reach with the current number of jumps.
        int end = 0;
        // The farthest index that can be reached from our current position.
        int farthest = 0;
        // Loop up to the second to last element.
        // We do not need to jump again if we are already at the last index.
        for (int i = 0; i < nums.length - 1; i++) {
            // Continuously update the farthest reachable index as we iterate.
            farthest = Math.max(farthest, i + nums[i]);
            // If we hit the boundary of the current jump, we MUST take another jump.
            if (i == end) {
                jumps++;
                // The new boundary becomes the farthest index we discovered along the way.
                end = farthest;
            }
        }

        return jumps;
    }
}
