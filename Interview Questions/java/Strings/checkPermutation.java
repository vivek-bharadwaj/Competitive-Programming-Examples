/**
 * Check Permutation: Given two strings, write a method to decide if one is a
 * permutation of the other.
 */

/*
 * Two solutions: 1. Sort both the strings Compare their lengths. If they aren't
 * equal, return false Compare character by character. If not equal, return
 * false Return true
 * 
 * 2. Assuming the character set is ASCII(128 chars) count occurrence of each
 * character in both strings. If not equal, return false Return true
 */

// Method 1
class Solution1 {
    private static String sort(String s) {
        char[] ch = s.toCharArray();
        java.util.Arrays.sort(ch);
        return new String(ch);
    }

    public static boolean checkPermutations(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        return sort(s1).equals(sort(s2));
    }
}

// Method 2

class Solution2 {
    public boolean permutations(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] letters = new int[128];

        char[] s1_Array = s1.toCharArray();
        for (char c : s1_Array) {
            letters[c]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            int c = (int) s2.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }
        return true;
    }
}