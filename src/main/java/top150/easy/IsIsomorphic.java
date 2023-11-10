package top150.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
    public static void main(String[] args) {
        String s = "abcdefghijklmnopqrstuvwxyzva";
        String t = "abcdefghijklmnopqrstuvwxyzck";
        System.out.println(isIsomorphic1(s, t));
    }

//  hashmap;  time: O(n), space: O(n)
    public static boolean isIsomorphic(String s, String t) {
        return transformString(s).equals(transformString(t));
    }
    public static String transformString(String str) {
        Map<Character, Integer> indexMapping = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i  = 0 ; i < str.length() ; i++) {
            char c = str.charAt(i);
            if(!indexMapping.containsKey(str.charAt(i))){
                indexMapping.put(c, i);
            }
            sb.append(indexMapping.get(c));
            sb.append(" ");
        }
//        System.out.println(sb);
        return sb.toString();
    }

//    (faster)char mapping with dictionary; time: O(n), space: O(1) [since, the size of ascii char set is fixed]
    public static boolean isIsomorphic1(String s, String t) {
        int[] mappingDictStoT = new int[256];
        Arrays.fill(mappingDictStoT, -1);
        int[] mappingDictTtoS = new int[256];
        Arrays.fill(mappingDictTtoS, -1);
        for(int i = 0 ; i < s.length() ; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(mappingDictStoT[c1] == -1 && mappingDictTtoS[c2] == -1) {
                mappingDictStoT[c1] = c2;
                mappingDictTtoS[c2] = c1;
            }
            else if(!(mappingDictStoT[c1] == c2 && mappingDictTtoS[c2] == c1)) {
                return false;
            }
        }
        return true;
    }

}

/*
Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true


Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.


First occurrence:
Is there any string transformation we can apply to both the strings such that to check for isomorphism, we simply check if their modified versions are exactly the same?
For each character in the given string, we replace it with the index of that character's first occurence in the string.
For each character in the given string, we replace it with the index of that character's first occurence in the string.
However, we should be mindful of transformations that use both one and two-digit numbers. Under these circumstances, the transformed strings can be misinterpreted.

 */
