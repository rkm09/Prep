package top150.easy;

public class MySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt1(4));
    }

//    binary search; time: O(logn), space: O(1)
    public static int mySqrt1(int x) {
        if(x < 2) return x;
        long num;
        int pivot, left = 2, right = x/2;
        while(left <= right) {
//            to prevent 32 bit integer overflow with high
            pivot = left + (right - left)/2;
            num = (long) pivot * pivot;
            if(num < x) left = pivot + 1;
            else if(num > x) right = pivot - 1;
            else return pivot;
        }
        return right;
    }

//    recursion and bit shift; time: O(logn), space: O(logn)
    public static int mySqrt(int x) {
        if(x < 2) return x;
        int left = mySqrt(x >> 2) << 1;
        int right = left + 1;
        return (long) right * right > x ? left : right;
    }

//    not for interviews O(1)
    public static int mySqrt3(int x) {
        if(x < 2) return x;
        int left = (int) Math.pow(Math.E, 0.5 * Math.log(x));
        int right = left + 1;
        return (long) right * right > x ? left : right;
    }
}

/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
You must not use any built-in exponent function or operator.
For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
Example 1:
Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:
Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
Constraints:

0 <= x <= 2^31 - 1

Recursion & bit shift:
sqrt(x) => 2 * sqrt(x/4) to base case reduction
can be simplified with bit shift:
x << y => x * 2^y
x << y => x / 2^y
sqrt(x) => sqrt(x >> 2) << 1
 */