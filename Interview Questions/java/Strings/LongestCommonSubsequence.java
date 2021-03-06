/*
LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. So a string of length n has 2^n different possible subsequences.

It is a classic computer science problem, the basis of diff (a file comparison program that outputs the differences between two files), and has applications in bioinformatics.

Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
*/

class Solution {
    public static int longestCommonSubsequenceTopDown(String s1, String s2) {
        /*
         * lcs("", anything) = 0 lcs(anything, "") = 0 lcs("", "") = 0
         * 
         * Recurrence relation lcs(s1, s2) = { 1 + lcs(s1withoutlastcharacter,
         * s2withoutlastcharacter) if last characters of s1 and s2 match
         * max(lcs(s1withoutlastcharacter, s2), lcs(s1, s2withoutlastcharacter)) if last
         * characters of s1 and s2 don't match }
         */

        if (s1.length() == 0 || s2.length() == 0) {
            return 0;
        }

        String s1WithoutLastChar = s1.substring(0, s1.length() - 1);
        String s2WithoutLastChar = s2.substring(0, s2.length() - 1);

        if (s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1)) {
            // Case 1: Match
            return 1 + longestCommonSubsequenceTopDown(s1WithoutLastChar, s2WithoutLastChar);
        } else {
            return Math.max(longestCommonSubsequenceTopDown(s1WithoutLastChar, s2),
                    longestCommonSubsequenceTopDown(s1, s2WithoutLastChar));
        }
    }

    // Bottom UP DP Solution using DP Table
    public static longestCommonSubsequenceBottomUp(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        
        for(int i = 0; i < s2.length() + 1; i++) {
            for(int j = 0; j < s1.length() + 1; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if(s2.charAt(i) == s1.charAt(j)) {
                    // Match
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[s2.length()][s1.length()];
    }
}