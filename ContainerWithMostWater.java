package leetcode.editor.en;

//You are given an integer array height of length n. There are n vertical lines 
//drawn such that the two endpoints of the iᵗʰ line are (i, 0) and (i, height[i]).
// 
//
// Find two lines that together with the x-axis form a container, such that the 
//container contains the most water. 
//
// Return the maximum amount of water a container can store. 
//
// Notice that you may not slant the container. 
//
// 
// Example 1: 
// 
// 
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,
//3,7]. In this case, the max area of water (blue section) the container can 
//contain is 49.
// 
//
// Example 2: 
//
// 
//Input: height = [1,1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
//
// Related Topics Array Two Pointers Greedy 👍 34564 👎 2221


public class ContainerWithMostWater {
    // Time Complexity: O( )
    // Space Complexity: O( )
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        // Initialize two pointers at both ends of the array to maximize the initial width.
        int left = 0;
        int right =height.length - 1;
        // Track the maximum area found so far (High Water Mark).
        int maxArea = 0;
        // Execute the loop as long as the search space is valid (pointers haven't met).
        while (left < right){
            // Calculate the area of the current container.
            // The effective height is strictly limited by the shorter line.
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            // Update the global maximum area if the current one yields a higher ROI.
            maxArea = Math.max(maxArea, currentArea);
            // Greedy Strategy: Always eliminate the shorter boundary.
            // Moving the shorter line is the only way to potentially increase the effective height.
            if (height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        // Return the optimal result.
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}