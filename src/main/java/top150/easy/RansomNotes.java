package top150.easy;

import java.util.HashMap;
import java.util.Map;

public class RansomNotes {
    public static void main(String[] args) {
        String ransomNote = "aa"; String magazine = "ab";
        System.out.println(canConstruct(ransomNote, magazine));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> hcount = new HashMap<>();
        for(char c : magazine.toCharArray()) {
            hcount.put(c, hcount.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> rcount = new HashMap<>();
        for(char c : ransomNote.toCharArray()) {
            rcount.put(c, rcount.getOrDefault(c, 0) + 1);
        }
        for(char c : rcount.keySet()) {
            if(!hcount.containsKey(c)) return false;
            if(hcount.get(c) < rcount.get(c)) return false;
        }
        return true;
    }
    
}
/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true


Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.
 */