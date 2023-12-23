package leet.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringTwoDistinct159 {
    public static void main(String[] args) {
        String s = "abcabcabc";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }

//    sliding window; time: O(n), space: O(1) since hashmap with atmost 3 elements
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if(n < 3) return n;
        int maxLength = 2;
        int left = 0, right = 0;
        Map<Character, Integer> hmap = new HashMap<>();
        while(right < n) {
            hmap.put(s.charAt(right), right++);
            if(hmap.size() == 3) {
                int delIdx = Collections.min(hmap.values());
                hmap.remove(s.charAt(delIdx));
                left = delIdx + 1;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}

/*
Given a string s, return the length of the longest substring
that contains at most two distinct characters.
Example 1:
Input: s = "eceba"
Output: 3
Explanation: The substring is "ece" which its length is 3.
Example 2:
Input: s = "ccaabbb"
Output: 5
Explanation: The substring is "aabbb" which its length is 5.
Constraints:
1 <= s.length <= 105
s consists of English letters.
 */