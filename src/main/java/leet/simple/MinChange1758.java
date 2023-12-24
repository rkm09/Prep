package leet.simple;

public class MinChange1758 {
    public static void main(String[] args) {
        String s = "1111";
        System.out.println(minOperations(s));
    }

//    time: O(n), space: O(1) startOne will be the polar opposite of startZero => n - startZero, so one var pass enough
    public static int minOperations(String s) {
        int startZero = 0, n = s.length();
        for(int i = 0 ; i < n ; i++) {
            char c = s.charAt(i);
            if(i % 2 == 0) {
                if(c == '1') {
                    startZero++;
                }
            } else {
                if(c == '0') {
                    startZero++;
                }
            }
        }
        return Math.min(startZero, n - startZero);
    }
}

/*
You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.
The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.
Return the minimum number of operations needed to make s alternating.
Example 1:
Input: s = "0100"
Output: 1
Explanation: If you change the last character to '1', s will be "0101", which is alternating.
Example 2:
Input: s = "10"
Output: 0
Explanation: s is already alternating.
Example 3:
Input: s = "1111"
Output: 2
Explanation: You need two operations to reach "0101" or "1010".
Constraints:
1 <= s.length <= 104
s[i] is either '0' or '1'.
 */