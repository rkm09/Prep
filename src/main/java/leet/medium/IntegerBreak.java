package leet.medium;

public class IntegerBreak {
    static int[] memo;
    public static void main(String[] args) {
        int n = 10;
        int res = integerBreak2(n);
        System.out.println(res);
    }

//    DP(top down - recursive) time: O(n^2), space: O(n)
    public static int integerBreak1(int n) {
        if(n < 4) return n-1;
        memo = new int[n+1];
        return dp(n);
    }
    public static int dp(int num) {
        if(num <= 3) return num;
        if(memo[num] != 0) return memo[num];
        int res = num;
        for(int i = 2; i < num ; i++) {
            res = Math.max(res, i * dp(num - i));
        }
        memo[num] = res;
        return res;
    }

//    DP (bottom up - iterative) time: O(n^2), space: O(n)
    public static int integerBreak2(int n) {

        if(n < 4) return n - 1;
        int[] dp = new int[n+1];
        for(int i = 0 ; i < 4 ; i++) {
            dp[i] = i;
        }
        for(int num = 4 ; num <= n ; num++) {
            int res = num ;
            for(int i = 2 ; i < num ; i++) {
                res = Math.max(res, i * dp[num - i]);
            }
            dp[num] = res;
        }
        return dp[n];
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

Let's say we have an integer num and split it into two integers: i and num - i. The highest product possible would be i * BEST, where BEST is the highest product possible from splitting up num - i.

Notice that the variable BEST represents the original problem with a different input (num - i). This allows us to think in terms of dynamic programming. Let's define a function dp(num) that returns the highest possible product from splitting num up.

We have the following base cases for this function:

If num == 1, then it isn't possible to split the number up, so we just return 1.
If num == 2, then it would be better to not split the number at all, since the only possible split 1 * 1 is less than 2, so just return 2. The exact same argument can be made for num == 3: the only possible split 1 * 2 is less than 3 itself, so just return 3.
Otherwise, we have two options:

Don't split the number up at all. We can initialize the answer as ans = num.
Split the number. We can try all possible splits. Iterate i from 2 until num. For each value of i, try to update ans with i * dp(num - i) if it is larger.
You may be thinking: what about the constraint where we need to have at least 2 integers? We need to check for 2 separate cases before performing the recursion.

If n == 2, we immediately return 1. The only possible split is 1 * 1.
If n == 3, we immediately return 2. The only possible split is 1 * 2.
We need to explicitly check for these cases before going into the recursion, otherwise, we would incorrectly return a larger answer since we initialize ans = num.

For all other values of n, the recursion will work. Take a look at the first few numbers:

For num = 4, we can do 2 * 2 = 4, which is not less than 4 itself.
For num = 5, we can do 2 * 3 = 6, which is not less than 5 itself.

As you can see, as n increases, the product from splitting becomes larger and larger, and thus we will always satisfy the requirement of needing to perform at least one split. The only cases where performing a split results in a lower product is 2, 3.

This solution will work, but you may notice that it will end up in a lot of duplicated computation. We will end up calculating many states multiple times. For example, if we called dp(15), it would make a call to dp(12) when calculating 3 * dp(12). If we later call dp(14), it will also make a call to dp(12) when calculating 2 * dp(12). To avoid computing the same states multiple times, we will use a technique called memoization. The first time we calculate dp(num), we will store the result. In the future, we can reference this result for num instead of having to recalculate it.



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