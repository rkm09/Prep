package leet.simple;

public class PowerOfFour {
    public static void main(String[] args) {
        int n = 16;
        boolean res = isPowerOfFour(n);
        System.out.println(res);
    }
    public static boolean isPowerOfFour(int n) {
        if(n == 0) return false;
        while(n % 4 == 0) n /= 4;
        return n == 1;
    }
}

/*
Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4^x.

Example 1:

Input: n = 16
Output: true
Example 2:

Input: n = 5
Output: false
Example 3:

Input: n = 1
Output: true
Constraints:

-2^31 <= n <= 2^31 - 1
 */
