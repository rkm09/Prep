package leet.simple;

public class PowerOfFour {
    public static void main(String[] args) {
        int n = 16;
        boolean res = isPowerOfFour3(n);
        System.out.println(res);
    }

//  time: O(logn)
    public static boolean isPowerOfFour(int n) {
        if(n == 0) return false;
        while(n % 4 == 0) n /= 4;
        return n == 1;
    }

//    Bitwise; time: O(1), space: O(1) !! For Power of Two
//    (x & (x-1)) == 0 only works with 1 bit set
    public static boolean isPowerOfTwo(int n) {
        if(n == 0) return false;
        long x = (long) n;
        return  (x & (x - 1)) == 0;
    }

//    Math; time: O(1), space: O(1)
    public static boolean isPowerOfFour2(int n) {
        return (n > 0) && (Math.log(n) / Math.log(2) % 2 == 0);
    }

//    Math; time: O(1), space: O(1)
    public static boolean isPowerOfFour3(int n) {
        return (n > 0) && ((n & (n - 1)) == 0) && (n % 3 == 1) ;
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
