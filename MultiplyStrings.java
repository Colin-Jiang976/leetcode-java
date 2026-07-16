package leetcode.editor.en;

class Solution {
    public String multiply(String num1, String num2) {
        // Edge case: If either multiplier is zero, return "0" immediately to save computation costs.
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // Allocate an array to act as a ledger for the product of each digit.
        // Max possible length of the product is the sum of the lengths of the two numbers.
        int[] res = new int[num1.length() + num2.length()];
        // Traverse both strings from right to left (least significant digit to most).
        for (int i = num1.length() - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            for (int j = num2.length() -1; j >= 0; j--){
                int digit2 = num2.charAt(j) - '0';
                // Calculate the product of current digits and add the existing value from the lower position.
                int sum =digit1 * digit2 + res[i + j + 1];
                // Update the current position (remainder) and carry over to the higher position (quotient).
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        // Find the first non-zero element to skip leading zeros.
        int pointer = 0;
        while (pointer < res.length && res[pointer] == 0){
            pointer++;
        }
        // Use StringBuilder for memory-efficient string concatenation (String is immutable).
        StringBuilder sb = new StringBuilder();
        for (int k = pointer; k < res.length; k++) {
            sb.append(res[k]);
        }
        // Fallback safeguard: return "0" if StringBuilder is empty.
        return sb.isEmpty() ? "0" : sb.toString();
    }
}
