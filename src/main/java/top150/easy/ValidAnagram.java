package top150.easy;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram2(s, t));
    }

//    time: O(n), space: O(1)
    public static boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] counter = new int[26];
        for(int i = 0 ; i < s.length() ; i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for(int count : counter) {
            if(count != 0)
                return false;
        }
        return true;
    }

//    time: O(nlogn), space: O(n) in java, otherwise space: O(1)
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        Arrays.sort(sarr);
        Arrays.sort(tarr);
        // for(int i = 0 ; i < sarr.length ; i++) {
        //     if(sarr[i] != tarr[i])
        //         return false;
        // }
//        ps: toCharArray was less expensive than split to string array. also, the loop is somehow faster
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


Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
Use a hash table instead of a fixed size counter. Imagine allocating a large size array to fit the entire range of unicode characters, which could go up to more than 1 million. A hash table is a more generic solution and could adapt to any range of characters.
To examine if ttt is a rearrangement of sss, we can count occurrences of each letter in the two strings and compare them. We could use a hash table to count the frequency of each letter, however, since both sss and ttt only contain letters from aaa to zzz, a simple array of size 26 will suffice.
 */