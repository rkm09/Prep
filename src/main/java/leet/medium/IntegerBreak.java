package leet.medium;

public class IntegerBreak {
    public static void main(String[] args) {
        int n = 10;
        int res = integerBreak4(n);
        System.out.println(res);
    }

//    Math 1 time: O(n), space: O(1)
    public static int integerBreak3(int n) {
        int res = 1;
        if(n <= 3) return n-1;
        while(n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }

//    Math 2 time: O(log n) for exponentiation, space: O(1)
    public static int integerBreak4(int n) {
        if(n <= 3) return n-1;
        if(n % 3 == 0) return (int) Math.pow(3, n/3);
        if(n % 3 == 1) return (int) Math.pow(3, n/3 - 1) * 4;
        return (int) Math.pow(3, n/3) * 2;
    }
}

/*
Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.

Return the maximum product you can get.

Example 1:

Input: n = 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.
Example 2:

Input: n = 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.


Constraints:

2 <= n <= 58

=============================================
DP:

Maths:
Interestingly, it is optimal to only split n into 2 and 3! Why is this the case? The following is not a strict mathematical proof, but gives an intuition as to why we should only split n into 2 and 3.
The inequality of arithmetic and geometric means shows that to maximize the product of a set of numbers with a fixed sum, the numbers should all be equal. This means that we should split n into a copies of x.
f(x) = x ^ (n/x)
This is the case when x=e=2.71828..
f is maximized at e. Unfortunately, e is not an integer, and this problem is called Integer Break. The nearest integer is 3, which suggests that we should try to use 3 as much as we can.
For numbers that are not divisible by 3, we will have remainders. This is where 2 comes in. For example, when n = 11, the maximum product is 54 = 3 * 3 * 3 * 2.
When we have n = 4, it is better to split it into 2 * 2 versus 3 * 1. Thus, the strategy of splitting into as many 3s only applies when n > 4. This brings us to our algorithm. As long as n > 4, keep splitting 3s. Once n <= 4, we can just multiply it directly with whatever product we have built up to that point.
Note that due to the constraint of needing to perform at least one split, we still need to account for the special cases when n <= 3.
 */