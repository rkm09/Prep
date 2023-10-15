package leet.hard;

import java.util.Arrays;

public class NumWaysToStay {
    private static int[][] memo;
    private static final int MOD = (int) 1e9 + 7;
    private static int arrLen;

    public static void main(String[] args) {
        int steps = 3, arrLen = 2;
        int res = numWays(steps, arrLen);
        System.out.println(res);
    }

//    Top Down DP
    public static int numWays(int steps, int arrLen) {
        arrLen = Math.min(arrLen, steps);
        memo = new int[arrLen][steps + 1];
        for(int[] row : memo)
            Arrays.fill(row, -1);
        return dp(0, steps);
    }
    public static int dp(int curr, int remain) {
        if(remain == 0) {
            if(curr == 0)
                return 1;
            return 0;
        }
        if(memo[curr][remain] != -1) return memo[curr][remain];

        int ans = dp(curr, remain - 1);
        if(curr > 0) {
            ans = (ans + dp(curr - 1, remain - 1)) % MOD;
        }
        if(curr < arrLen - 1) {
            ans = (ans + dp(curr + 1, remain - 1)) % MOD;
        }

        memo[curr][remain] = ans;
        return ans;
    }
}

/*
You have a pointer at index 0 in an array of size arrLen. At each step, you can move 1 position to the left, 1 position to the right in the array, or stay in the same place (The pointer should not be placed outside the array at any time).
Given two integers steps and arrLen, return the number of ways such that your pointer is still at index 0 after exactly steps steps. Since the answer may be too large, return it modulo 10^9 + 7.
Example 1:

Input: steps = 3, arrLen = 2
Output: 4
Explanation: There are 4 different ways to stay at index 0 after 3 steps.
Right, Left, Stay
Stay, Right, Left
Right, Stay, Left
Stay, Stay, Stay
Example 2:

Input: steps = 2, arrLen = 4
Output: 2
Explanation: There are 2 different ways to stay at index 0 after 2 steps
Right, Left
Stay, Stay
Example 3:

Input: steps = 4, arrLen = 2
Output: 8


Constraints:

1 <= steps <= 500
1 <= arrLen <= 10^6

We start at 0, need to make steps moves, and want to end up back at 0. Without loss of generality, let's say we are currently at curr on the number line and need to make remain more moves. We have three options:

Don't move. We will stay at curr and need to make remain - 1 more moves.
Move left. We can only do this if curr > 0. We move to curr - 1 and need to make remain - 1 more moves.
Move right. We can only do this if curr < arrLen - 1. We move to curr + 1 and need to make remain - 1 more moves.
Let's define a function dp(curr, remain) that returns the number of ways we can arrive at 0 from curr after remain moves. If we want to go back to 0, we can only do so through one of these three options. In other words, the number of ways to return to 0 from the current state is equivalent to the sum of the number of ways to return to 0 in the next three options. We have the following transitions:

dp(curr, remain) += dp(curr, remain - 1)
dp(curr, remain) += dp(curr - 1, remain - 1) if curr > 0
dp(curr, remain) += dp(curr + 1, remain - 1) if curr < arrLen - 1>
What will be the base case of this function? If remain = 0, we have no more moves to make. If curr = 0, then we have found a way to accomplish our task, so we return 1. Otherwise, we return 0.

Complexity Analysis:

Given n as steps and m as arrLen,

Time complexity: O(n⋅min(n,m))

There can be steps values of remain and min(steps, arrLen) values of curr. The reason curr is limited by steps is because if we were to only move right, we would eventually run out of moves. Due to memoization, we never calculate a state more than once. To calculate a given state costs O(1) as we are simply adding up three options.

Space complexity: O(n⋅min(n,m))

The recursion call stack uses up to O(n) space, but this is dominated by memo which has a size of O(n⋅min(n,m)).
 */