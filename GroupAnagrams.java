package leetcode.editor.en;

//Given an array of strings strs, group the anagrams together. You can return 
//the answer in any order. 
//
// 
// Example 1: 
//
// 
// Input: strs = ["eat","tea","tan","ate","nat","bat"] 
// 
//
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// Explanation: 
//
// 
// There is no string in strs that can be rearranged to form "bat". 
// The strings "nat" and "tan" are anagrams as they can be rearranged to form 
//each other. 
// The strings "ate", "eat", and "tea" are anagrams as they can be rearranged 
//to form each other. 
// 
//
// Example 2: 
//
// 
// Input: strs = [""] 
// 
//
// Output: [[""]] 
//
// Example 3: 
//
// 
// Input: strs = ["a"] 
// 
//
// Output: [["a"]] 
//
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] consists of lowercase English letters. 
// 
//
// Related Topics Array Hash Table String Sorting 👍 22220 👎 760

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams {
    // Time Complexity: O( )
    // Space Complexity: O( )
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // Time Complexity: O(N * K) where N is the length of strs and K is the maximum length of a string.
        // Space Complexity: O(N * K) to store the result in the hash map.
    public List<List<String>> groupAnagrams(String[] strs) {
        // Base case: return an empty list if the input is null or empty
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        // Map to store the frequency signature as the key and the grouped anagrams as the value
        HashMap<String, List<String>> anagramGroups = new HashMap<>();
        // Iterate through each string in the given array
        for (String s : strs){
            // Create a frequency array for the 26 lowercase English letters
            int[] count = new int[26];
            // Count the occurrences of each character in the current string
            for (char c : s.toCharArray()){
                count[c - 'a']++;
            }
            // Convert the frequency array into a string to act as a unique signature
            String signature = Arrays.toString(count);
            // If the signature is not in the map, initialize a new empty list
            if (!anagramGroups.containsKey(signature)){
                anagramGroups.put(signature, new ArrayList<>());
            }
            // Add the current string to its corresponding anagram group
            anagramGroups.get(signature).add(s);
        }
        // Return all the grouped lists of anagrams
        return new ArrayList<>(anagramGroups.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}