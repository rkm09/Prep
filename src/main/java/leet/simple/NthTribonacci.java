package leet.simple;

import java.util.HashMap;

public class NthTribonacci {
    private static HashMap<Integer, Integer> dp  = new HashMap<>() {{
        put(0, 0);
        put(1, 1);
        put(2, 1);
    }};
    public static void main(String[] args) {
        int n = 4;
        int res = tribonacci2(n);
        System.out.println(res);
    }

//    DP(top down)
    public static int tribonacci(int n) {
        return dfs(n);
    }
    private static int dfs(int n) {
        if(dp.containsKey(n)) return dp.get(n);
        int ans = dfs(n-1) + dfs(n-2) + dfs(n-3);
        dp.put(n, ans);
        return ans;
    }

//    DP(Bottom up); time: O(n), space O(n)
    public static int tribonacci1(int n) {
        if(n < 3) {
            return n > 0 ? 1 : 0;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3 ; i <= n ; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }

//    DP(Bottom up); time: O(n), space O(1)
    public static int tribonacci2(int n) {
        if(n < 3) {
            return n > 0 ? 1 : 0;
        }
        int a = 0,  b = 1, c = 1;
        for(int i = 3 ; i <= n ; i++) {
            int tmp = a + b + c;
            a = b;
            b = c;
            c = tmp;
        }
        return c;
    }
}

/*
The Tribonacci sequence Tn is defined as follows:
T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
Given n, return the value of Tn.

Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
Example 2:

Input: n = 25
Output: 1389537


Constraints:

0 <= n <= 37
The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.


Complexity Analysis
Time complexity: O(n)
We recursively call dfs on subproblems and each subproblem dfs(i) is computed once.
Space complexity: O(n)
The hash map dp contains at most n + 1 key-value pairs.

 */