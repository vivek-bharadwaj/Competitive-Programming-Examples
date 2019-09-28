/**
 * Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
 */

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Hash Table solution - O(N) time, O(N) space
        Set<Integer> set = new HashSet();
        
        for (int n : nums) {
            if (set.contains(n)) {
                return true;
            }
            set.add(n);
        }
        return false;
    }

    // Alternate solution for small N in O(N logN) time and O(1) space is to sort the array and compare adjacent indices.
}