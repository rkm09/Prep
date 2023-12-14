package top150.medium;

import java.util.Arrays;

public class HouseRobber198 {
    private static int[] memo = new int[100];
    public static void main(String[] args) {
        int[] nums = {100, 400, 400, 200};
//        int[] nums = {100, 50, 400, 200, 100};
        System.out.println(rob2(nums));
    }

//    Space optimized DP; time: O(N), space: O(1)
    public static int rob2(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int robNextPlusOne = 0;
        int robNext = nums[n-1];
        for(int i = n - 2 ; i >= 0 ; i--) {
            int current = Math.max(robNext, robNextPlusOne + nums[i]);
            robNextPlusOne = robNext;
            robNext = current;
        }
        return robNext;
    }

    //  DP; time: O(N), space: O(N)
    public static int rob1(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] robFrom = new int[n+1];
        robFrom[n] = 0;
        robFrom[n-1] = nums[n-1];
        for(int i = n - 2 ; i >= 0 ; i--) {
            robFrom[i] = Math.max(robFrom[i+1], robFrom[i+2] + nums[i]);
        }
        return robFrom[0];
    }

//    recursion + memo; time: O(N), space: O(N)
    public static int rob(int[] nums) {
        Arrays.fill(memo, -1);
        return robFrom(0, nums);
    }
    private static int robFrom(int index, int[] nums) {
        if(index >= nums.length) return 0;
        if(memo[index] != -1) {
            return memo[index];
        }
        int ans = Math.max(robFrom(index + 1, nums), robFrom(index + 2, nums) + nums[index]);
        memo[index] = ans;
        return ans;
    }

}



/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 400

Approach 1: Recursion + memoization
Complexity Analysis
Time Complexity: O(N) since we process at most NNN recursive calls, thanks to caching, and during each of these calls, we make an O(1) computation which is simply making two other recursive calls, finding their maximum, and populating the cache based on that.
Space Complexity: O(N) which is occupied by the cache and also by the recursion stack.

Approach2 : Dynamic Programming (better)
The idea here is the same as before except that instead of following a recursive approach, we will be sticking with a tabular approach. The recursive approach may run into trouble when the recursion stack grows too large. It may also run into trouble because, for each recursive call, the compiler must do additional work to maintain the call stack (function variables, etc.) which results in unwanted overhead. The dynamic programming approach is simply a tabular formulation of the ideas presented above.
The cache we had before will still exist in this approach but instead of calling it a cache, we will refer to it as our dynamic programming table. Every DP solution has a table that we populate starting with the base case or the simplest of cases for which we already know the answer. E.g. for our problem, we know that in the absence of houses, the robber will make 0 profit. Similarly, if there is just one house left to rob, the robber will rob that house, and that will be the maximum profit.
We start by populating the dynamic programming table with these initial values and then build the table in a bottom-up fashion which is the essence of this solution.
Complexity Analysis
Time Complexity: O(N) since we have a loop from N−2⋯0 and we simply use the pre-calculated values of our dynamic programming table for calculating the current value in the table which is a constant time operation.
Space Complexity: O(N) which is used by the table. So what is the real advantage of this solution over the previous solution? In this case, we don't have a recursion stack. When the number of houses is large, a recursion stack can become a serious limitation, because the recursion stack size will be huge and the compiler will eventually run into stack-overflow problems (no pun intended!).

Approach3 : Space Optimized DP:
To calculate the current value, we just need to rely on the next two consecutive values/recursive calls.
*/
