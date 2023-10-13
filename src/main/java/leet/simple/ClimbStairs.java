package leet.simple;

public class ClimbStairs {

    public static void main(String[] args) {
        int res = climbStairs(2);
        System.out.println(res);
    }

//    Fibonacci number; time: O(n), space: O(1)
    public static int climbStairs(int n) {
        if(n == 1) return 1;
        int first = 1;
        int second = 2;
        for(int i = 3 ; i <= n ; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

//    DP time: O(n), space: O(n)
    public static int climbStairs1(int n) {
        if(n == 1) return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }


//    Recursion with memoization; time: O(n), space: O(n)
    public static int climbStairs2(int n) {
        int[] memo = new int[n+1];
        return climbStairsRec2(0, n, memo);
    }
    public static int climbStairsRec2(int i, int n, int[] memo) {
        if(i > n) return 0;
        if(i == n) return 1;
        if(memo[i] > 0) return memo[i];
        memo[i] = climbStairsRec2(i+1, n, memo) + climbStairsRec2(i+2, n, memo);
        return memo[i];
    }

//    Recursive brute force : time: O(2^n) size of the recursion tree, space: O(n) depth of the tree [TLE :|]
    public static int climbStairs3(int n) {
        return climbStairsRec3(0, n);
    }
    public static int climbStairsRec3(int i, int n) {
        if(i > n) return 0;
        if(i == n) return 1;
        return climbStairsRec3(i+1, n) + climbStairsRec3(i+2, n);
    }
}

/*
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step


Constraints:

1 <= n <= 45


 */