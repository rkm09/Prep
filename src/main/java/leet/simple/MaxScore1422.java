package leet.simple;

public class MaxScore1422 {
    public static void main(String[] args) {
        String s = "011101";
        System.out.println(maxScore(s));
    }

//     brute force [def];
    public static int maxScore(String s) {
        int n = s.length(), max = Integer.MIN_VALUE;
        for(int i = 1 ; i <= n ; i++) {
            String k = s.substring(0, i);
            String k1 = s.substring(i,n);
            max = Math.max(max, count(k, true) + count(k1, false));
        }
        return max;
    }
    private static int count(String s1, boolean isZero) {
        int count = 0;
        for(int i = 0 ; i < s1.length() ; i++) {
            if(isZero) {
                if(s1.charAt(i) == '0') count++;
            } else {
                if(s1.charAt(i) == '1') count++;
            }
        }
        return count;
    }
}

/*
Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty substrings (i.e. left substring and right substring).
The score after splitting a string is the number of zeros in the left substring plus the number of ones in the right substring.
Example 1:
Input: s = "011101"
Output: 5
Explanation:
All possible ways of splitting s into two non-empty substrings are:
left = "0" and right = "11101", score = 1 + 4 = 5
left = "01" and right = "1101", score = 1 + 3 = 4
left = "011" and right = "101", score = 1 + 2 = 3
left = "0111" and right = "01", score = 1 + 1 = 2
left = "01110" and right = "1", score = 2 + 1 = 3
Example 2:
Input: s = "00111"
Output: 5
Explanation: When left = "00" and right = "111", we get the maximum score = 2 + 3 = 5
Example 3:
Input: s = "1111"
Output: 3
Constraints:
2 <= s.length <= 500
The string s consists of characters '0' and '1' only.
 */
