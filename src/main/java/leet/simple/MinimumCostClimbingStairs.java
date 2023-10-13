package leet.simple;

import java.util.HashMap;

public class MinimumCostClimbingStairs {
    private static HashMap<Integer, Integer> memo = new HashMap<>();
    public static void main(String[] args) {
        int[] cost = {10,15,10};
        int res = minCostClimbingStairs(cost);
        System.out.println(res);
    }

//    bottom up, constant space; time: O(n), space: O(1) we just need the last two values (fastest)
    public static int minCostClimbingStairs(int[] cost) {
        int downOne = 0;
        int downTwo = 0;
        for(int i = 2 ; i < cost.length + 1 ; i++) {
            int temp = downOne;
            downOne = Math.min(downOne + cost[i-1], downTwo + cost[i-2]);
            downTwo = temp;
        }
        return downOne;
    }

//    Top Down DP (recursion + memoization); time: O(n), space: O(n)
    public static int minCostClimbingStairs1(int[] cost) {
        return minimumCost(cost.length, cost);
    }

    private static int minimumCost(int i, int[] cost) {
        if(i <= 1) return 0;
        if(memo.containsKey(i)) return memo.get(i);
        int downOne = minimumCost(i-1, cost) + cost[i-1];
        int downTwo = minimumCost(i-2, cost) + cost[i-2];
        memo.put(i, Math.min(downOne, downTwo));
        return memo.get(i);
    }

//  Bottom up DP (iterative); Time: O(n), Space: O(n)
    public static int minCostClimbingStairs2(int[] cost) {
        // The array's length should be 1 longer than the length of cost
        // This is because we can treat the "top floor" as a step to reach
        int[] minimumCost = new int[cost.length + 1];
        // Start iteration from step 2, since the minimum cost of reaching
        // step 0 and step 1 is 0
        for(int i = 2; i < minimumCost.length ; i++) {
            int takeOneStep = minimumCost[i-1] + cost[i-1];
            int takeTwoStep = minimumCost[i-2] + cost[i-2];
            minimumCost[i] = Math.min(takeOneStep, takeTwoStep);
        }
        // The final element in minimumCost refers to the top floor
        return minimumCost[minimumCost.length-1];
    }


}

/*
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.



Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.


Constraints:

2 <= cost.length <= 1000
0 <= cost[i] <= 999
 */
