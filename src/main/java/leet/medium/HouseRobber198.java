package leet.medium;

import java.util.Arrays;

public class HouseRobber198 {
    private static int[] memo = new int[100];
    public static void main(String[] args) {
        int[] nums = {100, 400, 400, 200};
//        int[] nums = {100, 50, 400, 200, 100};
        System.out.println(rob(nums));
    }

//    recursion + memo; time: O(N), space: O(N)
    private static int rob(int[] nums) {
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
 */
