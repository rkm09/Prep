package top150.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak139 {
    public static void main(String[] args) {
        List<String> wordDict = List.of("leet", "code");
        String s = "leetcode";
        System.out.println(wordBreak(s, wordDict));
    }

//    DP; time: O(n^3 + (m.k)), space: O(n + m.k)
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        Set<String> words = new HashSet<>(wordDict);
        dp[0] = true;
        for(int i = 1; i <= n ; i++) {
            for(int j = 0 ; j < i ; j++) {
                if(dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}
/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.
Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
Constraints:
1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.

DP:
Complexity Analysis
Given n as the length of s, m as the length of wordDict, and k as the average length of the words in wordDict,
Time complexity: O(n^3+m⋅k)
First, we spend O(m⋅k) to convert wordDict into a set. Then we have a nested loop over n, which iterates O(n^2) times. For each iteration, we have a substring operation which could cost up to O(n). Thus, this nested loop costs O(n^3).
Space complexity: O(n+m⋅k)
The dp array takes O(n) space. The set words takes up O(m⋅k) space.

 */
