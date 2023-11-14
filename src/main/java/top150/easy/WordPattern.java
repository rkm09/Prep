package top150.easy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(wordPattern1(pattern, s));
    }

    public static boolean wordPattern1(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length()) return false;
        Map hmap = new HashMap();
        for(Integer i = 0 ; i < words.length ; i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            if(!hmap.containsKey(w)) {
                hmap.put(w, i);
            }
            if(!hmap.containsKey(pattern.charAt(i))) {
                hmap.put(c, i);
            }
            if(hmap.get(w) != hmap.get(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] patarr = pattern.split("");
        String[] sarr = s.split(" ");
        if(pattern.length() != sarr.length) return false;
        return transform(patarr).equals(transform(sarr));
    }
    public static String transform(String[] arr) {
        Map<String, Integer> smap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < arr.length ; i++) {
            if(!smap.containsKey(arr[i])) {
                smap.put(arr[i], i);
                sb.append(i);
            } else {
                sb.append(smap.get(arr[i]));
            }
        }
        return sb.toString();
    }
}

/*
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.



Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false


Constraints:

1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.

Complexity Analysis

Time complexity : O(N+M) where N represents the length of s and M represents the length of pattern. All operations in the algorithm are linear with the length of the inputs.

Space complexity :O(W) where W is the number of unique characters in pattern and words in s, for the same reasons as the previous approach.
 */