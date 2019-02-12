/*
Given two strings, determine whether they are anagrams.
 */

/* 
Assuming all characters are lower case, ASCII
*/

 public boolean isAnagram(String s1, String s2) {
    if(s1.length() != s2.length()) 
        return false;

    s1 = s1.toLowerCase();
    s2 = s2.toLowerCase();

    int [] countOfLetters = new int[256];

    for(char c : s1.toCharArray()) {
        countOfLetters[c]++;
    } 

    for(char c : s2.toCharArray()) {
        countOfLetters[c]--;
    }

    for(int i : countOfLetters) {
        if(i != 0)
            return false;
    }

    return true;
 }