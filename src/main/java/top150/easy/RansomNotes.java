package top150.easy;

import java.util.HashMap;
import java.util.Map;

public class RansomNotes {
    public static void main(String[] args) {
        String ransomNote = "aa"; String magazine = "ab";
        System.out.println(canConstruct1(ransomNote, magazine));
    }



//    2 hashmaps
    public static boolean canConstruct(String ransomNote, String magazine) {

        if(magazine.length() < ransomNote.length()) {
            return false;
        }

        Map<Character, Integer> magazineCounts = makeCountsMap(magazine);
        Map<Character, Integer> ransomCounts = makeCountsMap(ransomNote);

        for(char c : ransomCounts.keySet()) {
            if(!magazineCounts.containsKey(c)) return false;
            if(magazineCounts.get(c) < ransomCounts.get(c)) return false;
        }

        return true;
    }

    private static Map<Character, Integer> makeCountsMap(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for(char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        return counts;
    }

    //    1 hashmap [performs worse than 2 hashmap at runtime]
    public static boolean canConstruct1(String ransomNote, String magazine) {
        if(magazine.length() < ransomNote.length()) {
            return false;
        }

        Map<Character, Integer> magazineCounts = makeCountsMap(magazine);
        for(char c : ransomNote.toCharArray()) {
            int countInMagazine = magazineCounts.getOrDefault(c, 0);
            if(countInMagazine == 0) {
                return false;
            }
            magazineCounts.put(c, countInMagazine - 1);
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

Approach: 2 hashmap
The basic HashMap operations, get(...) and put(...), are O(1) time complexity.

Time Complexity : O(m).

When m<n, we immediately return false. Therefore, the worst case occurs when m≥nm ≥ nm≥n.

Creating a HashMap of counts for the magazine is O(m), as each insertion/ count update is is O(1), and is done for each of the mmm characters.

Likewise, creating the HashMap of counts for the ransom note is O(n).

We then iterate over the ransom note HashMap, which contains at most nnn unique values, looking up their counterparts in the magazine `HashMap. This is, therefore, at worst O(n).

This gives us O(n)+O(n)+O(m). Now, remember how we said m≥n. This means that we can simplify it to O(m)+O(m)+O(m)=3⋅O(m), dropping the constant of 3.

Space Complexity : O(k) / O(1).

We build two HashMaps of counts; each with up to k characters in them. This means that they take up O(k) space.

For this problem, because kkk is never more than 26, which is a constant, it'd be reasonable to say that this algorithm requires O(1) space.


 */