package leet.simple;

import java.util.HashMap;
import java.util.Map;

public class CountCharacters1160 {
    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.println(countCharacters(words, chars));
    }
    public static int countCharacters(String[] words, String chars) {
        int ans = 0;
        int m = chars.length();
        Map<Character, Integer> hcount = new HashMap<>();
        for(Character c : chars.toCharArray()) {
            hcount.put(c, hcount.getOrDefault(c, 0) + 1);
        }
        System.out.println(hcount);
        for(int i = 0 ; i < words.length ; i++) {
            int n = words[i].length();
            if(n > m) continue;
            Map<Character, Integer> hc = new HashMap<>();
            for(Character c : words[i].toCharArray()) {
                hc.put(c, hc.getOrDefault(c, 0) + 1);
            }
            boolean flag = true;
            for(Character key : hc.keySet()) {
                if(!hcount.containsKey(key)) {
                    flag = false;
                    break;
                } else {
                    if(hc.get(key) > hcount.get(key)) {
                        flag = false; break;
                    }
                }
            }
            if(flag) {
                ans += n;
            }
        }
        return ans;
    }
}

/*
You are given an array of strings words and a string chars.
A string is good if it can be formed by characters from chars (each character can only be used once).
Return the sum of lengths of all good strings in words.
Example 1:
Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
Example 2:
Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
Constraints:
1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
words[i] and chars consist of lowercase English letters.
 */