/**
Given a non-empty array of integers, every element appears twice except for one. Find that single one.
Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
 */

//Using HashSet
public int singleNumber(int[] arr) {
    Set<Integer> set = new HashSet<>();
    for(int i : arr) {
        if(set.contains(i))
            set.remove(i);
        else
            set.add(i);
    }
    return set.iterator().next();
}

// Using Bit Manipulation
public int singleNumber(int[] arr) {
    int xorSum = 0;
    for(int i : arr) {
        xorSum ^= i;
    }
    return xorSum;
}

/*
Using Math:
Calculate Actual Sum of given array
Calculate Expected Sum -> sum(set(array))
Answer = 2 * Expected Sum - Actual Sum
*/

public int singleNumber(int[] arr) {
    
    int actualSum = arr[0];
    for(int i = 1; i < arr.length; i++) {
        actualSum += arr[i];
    }

    Set<Integer> set = new HashSet<>();
    for(int i : arr) {
        set.add(i);
    }

    int n = set.size();
    int expectedSum = 0;
    
    for(int i : set) {
        expectedSum += i;
    }

    return 2 * expectedSum - actualSum;
}
