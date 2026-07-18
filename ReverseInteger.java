package leetcode.editor.en;

class Solution {
    public int reverse(int x) {
        int result = 0;
        // Process all digits until the number is reduced to 0.
        // This condition elegantly handles both positive and negative integers.
        while (x != 0) {
            // Extract the rightmost digit (Pop mechanism)
            int pop = x % 10;
            // Truncate the rightmost digit from the original number
            x = x / 10;
            // Pre-emptive overflow/underflow checks before multiplying by 10.
            // If result exceeds MAX_VALUE / 10, the subsequent multiplication will overflow.
            if (result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            // If result drops below MIN_VALUE / 10, the subsequent multiplication will underflow.
            if (result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            // Shift existing digits to the left and append the extracted digit (Push mechanism)
            result = result * 10 + pop;
        }

        return result;
    }
}
