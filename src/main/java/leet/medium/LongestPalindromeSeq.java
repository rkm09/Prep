package leet.medium;

public class LongestPalindromeSeq {
    public static void main(String[] args) {
        String s = "abcdce";
        String res = longestPalindrome(s);
        System.out.println(res);
    }

    

//    basic brute force :p ; time: O(n^3), space: O(1) [check window]
    public static String longestPalindrome(String s) {
        for(int len = s.length(); len > 0 ; len--) {
            for(int start = 0 ; start <= s.length() - len ; start++) {
                if(check(start, start + len, s)) {
                    return s.substring(start, start + len);
                }
            }
        }
        return "";
    }
    private static boolean check(int i, int j, String s) {
        int left = i;
        int right = j - 1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            ++left;
            --right;
        }
        return true;
    }
}

/*
Given a string s, return the longest
palindromic substring in s.
Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
 */