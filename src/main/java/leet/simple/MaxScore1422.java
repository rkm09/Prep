package leet.simple;

public class MaxScore1422 {
    public static void main(String[] args) {
        String s = "011101";
        System.out.println(maxScore2(s));
    }

//    one pass; time: O(n), space: O(1)
//    Score = ZeroL + OneR => ZeroL + (TotalOnes[a constant] - OneL) => (ZeroL - OneL) + TotalOnes
    public static int maxScore2(String s) {
        int ones = 0, zeroes = 0, n = s.length();
        int best = Integer.MIN_VALUE;
        for(int i = 0 ; i < n - 1; i++) {
            if(s.charAt(i) == '1') {
                ones++;
            } else {
                zeroes++;
            }
            best = Math.max(best, zeroes - ones);
        }
        if(s.charAt(n - 1) == '1') {
            ones++;
        }
        return best + ones;
    }

//    two pass; time: O(n), space: O(1)
    public static int maxScore1(String s) {
        int zeroes = 0, ones = 0, max = 0;
        int n = s.length();
        for(int i = 0 ; i < n ; i++) {
            if(s.charAt(i) == '1') {
                ones++;
            }
        }
        for(int i = 0 ; i < n - 1 ; i++) {
            if(s.charAt(i) == '1') {
                ones--;
            } else {
                zeroes++;
            }
            max = Math.max(max, zeroes + ones);
        }
        return max;
    }

//     brute force [def]; time: O(n^2), space: O(1)
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
