package leet.simple;

import java.util.HashMap;
import java.util.Map;

public class CountCharacters1160 {
    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.println(countCharacters1(words, chars));
    }

//    arrays; time: O(n+m.k), space: O(1) [much faster at runtime]
    public static int countCharacters1(String[] words, String chars) {
        int ans = 0, n = chars.length();
        int[] counts = new int[26];
        for(Character c : chars.toCharArray()) {
            counts[c - 'a']++;
        }
        for(String word : words) {
            int m = word.length();
            if(m > n) continue;
            int[] wordCount = new int[26];
            for(Character c : word.toCharArray()) {
                wordCount[c - 'a']++;
            }
            boolean good = true;
            for(int i = 0 ; i < 26 ; i++) {
                if(wordCount[i] > counts[i]) {
                    good = false; break;
                }
            }
            if(good) {
                ans += m;
            }
        }
        return ans;
    }

//    [def] hashmap; time: O(n+m.k), space: O(1)
    public static int countCharacters(String[] words, String chars) {
        int ans = 0;
        int m = chars.length();
        Map<Character, Integer> counts = new HashMap<>();
        for(Character c : chars.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        for(String word : words) {
            int n = word.length();
            if(n > m) continue;
            Map<Character, Integer> wordCount = new HashMap<>();
            for(Character c : word.toCharArray()) {
                wordCount.put(c, wordCount.getOrDefault(c, 0) + 1);
            }
            boolean good = true;
            for(Character key : wordCount.keySet()) {
                if(wordCount.get(key) > counts.getOrDefault(key, 0)) {
                    good = false; break;
                }
            }
            if(good) {
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

Array:
Complexity Analysis
Given n as the length of chars, mmm as the length of words, and k as the average length of each word in words,
Time complexity: O(n+m⋅k)
To calculate counts, we iterate over each character of chars once, costing O(n).
Next, we iterate over O(m) elements in words. For each element, we calculate wordCount by iterating over the element, which costs O(k)O(k)O(k). We then perform a loop over 26 indices, costing O(1). Overall, the for loop costs O(m⋅k).
Space complexity: O(1)
counts and wordCount both have a fixed length of 26.

Hashmap:
Given n as the length of chars, m as the length of words and k as the average length of each word in words,
Time complexity: O(n+m⋅k)
To calculate counts, we iterate over each character of chars once, costing O(n).
Next, we iterate over O(m) elements in words. For each element, we calculate wordCount by iterating over the element, which costs O(k)O(k)O(k). We then iterate over wordCount. As the input only contains lowercase English letters, this costs O(1) since wordCount cannot have a length greater than 26. Overall, the for loop costs O(m⋅k).
Space complexity: O(1)
We use extra space for counts and wordCount. However, the input only contains lowercase English letters. Thus, the size of these hash maps never exceed 26, so we use O(1) space.
 */