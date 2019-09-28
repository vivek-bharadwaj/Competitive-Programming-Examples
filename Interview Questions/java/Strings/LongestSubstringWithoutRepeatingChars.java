/**
 * Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Sliding Window Technique
        if (s.length() < 1) {
            return 0;
        }
        
        Map<Character, Integer> charMap = new HashMap();
        int left = 0, right = 0, maxLen = 0;
        
        for (; right < s.length(); right++) {
            if (charMap.containsKey(s.charAt(right))) {
                left = Math.max(left, charMap.get(s.charAt(right)) + 1);
            }
            charMap.put(s.charAt(right), right);
            maxLen = Math.max(maxLen, right - left + 1);

        }
        return maxLen;
    }
}