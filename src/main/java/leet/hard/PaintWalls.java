package leet.hard;

public class PaintWalls {
    private static int[][] memo;
    private static int n;
    public static void main(String[] args) {
        int[] cost = {1,2,3,2};
        int[] time = {1,2,3,2};
        int res = paintWalls3(cost, time);
        System.out.println(res);
    }

//    DP: Bottom up
    public static int paintWalls3(int[] cost, int[] time) {
        n = cost.length;
        memo = new int[n][n+1];
        return dp(0, n, cost, time);
    }
    public static int dp(int i, int remain, int[] cost, int[] time) {
        if(remain <= 0) return 0;
        if(i == n) return (int)1e9;

        if(memo[i][remain] != 0) return memo[i][remain];
        int paint = cost[i] + dp(i+1, remain - 1 - time[i], cost, time);
        int dontPaint = dp(i+1, remain, cost, time);
        memo[i][remain] = Math.min(paint, dontPaint);

        return memo[i][remain];
    }
}

/*
You are given two 0-indexed integer arrays, cost and time, of size n representing the costs and the time taken to paint n different walls respectively. There are two painters available:

A paid painter that paints the ith wall in time[i] units of time and takes cost[i] units of money.
A free painter that paints any wall in 1 unit of time at a cost of 0. But the free painter can only be used if the paid painter is already occupied.
Return the minimum amount of money required to paint the n walls.

Example 1:

Input: cost = [1,2,3,2], time = [1,2,3,2]
Output: 3
Explanation: The walls at index 0 and 1 will be painted by the paid painter, and it will take 3 units of time; meanwhile, the free painter will paint the walls at index 2 and 3, free of cost in 2 units of time. Thus, the total cost is 1 + 2 = 3.
Example 2:

Input: cost = [2,3,4,2], time = [1,1,1,1]
Output: 4
Explanation: The walls at index 0 and 3 will be painted by the paid painter, and it will take 2 units of time; meanwhile, the free painter will paint the walls at index 1 and 2, free of cost in 2 units of time. Thus, the total cost is 2 + 2 = 4.


Constraints:

1 <= cost.length <= 500
cost.length == time.length
1 <= cost[i] <= 106
1 <= time[i] <= 500

Complexity Analysis

Given nnn as the length of cost and time,

Time complexity: O(n2)
i ranges from 0 to n and remain ranges from n to 0. Each state is calculated only once due to memoization. To calculate a state, we simply check two options paint and dontPaint, which costs O(1).

Space complexity: O(n2)
We use some space for the recursion call stack, but it is dominated by the space used to memoize our function, which is equal to the number of states.

Let dp(i, remain) be a function that returns the minimum cost to paint remain walls when considering index i and beyond. We have two base cases here.

If remain <= 0, we have painted all the walls. We can return 0.
If i == n, we have run out of walls to put the paid painter on and the task is impossible. We return a large value like infinity.
Now, how do we calculate a given state (i, remain)? we have two options. We can either hire the paid painter for this wall or not hire them.

If we hire them, as mentioned above, we spend cost[i] and paint 1 + time[i] walls. Then, we move to the next index. Thus, the cost of this option is cost[i] + dp(i + 1, remain - 1 - time[i]).
If we don't hire them, we simply move to the next index. The cost of this option is dp(i + 1, remain).
 */