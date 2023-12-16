package leet.simple;

import java.util.Arrays;

public class ValidAnagram242 {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
//    [def] sort; time: O(nlogn), space: O(n) 
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        Arrays.sort(sarr);
        Arrays.sort(tarr);
        return Arrays.equals(sarr, tarr);
    }
}

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
Example 1:
Input: s = "anagram", t = "nagaram"
Output: true
Example 2:
Input: s = "rat", t = "car"
Output: false
Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 */