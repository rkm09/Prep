package leet.simple;

import java.util.Arrays;

public class TwoSumLessThanK_1099 {
    public static void main(String[] args) {
        int[] nums = {34,23,1,24,75,33,54,8};
        int k = 60;
        System.out.println(twoSumLessThanK1(nums, k));
    }


//    2 pointer; time: O(nlogn), space: O(logn) or O(n) depending on the algo
    public static int twoSumLessThanK1(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = -1;
        int left = 0, right = n - 1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum < k) {
                ans = Math.max(sum, ans);
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

//    brute force; [def]; time: O(n^2), space: O(1)
    public static int twoSumLessThanK(int[] nums, int k) {
        int n = nums.length;
        int sum = -1;
        for(int i = 0 ; i < n ; i++) {
            int lsum;
            for(int j = i + 1 ; j < n ; j++) {
                lsum = nums[i] + nums[j];
                if(lsum < k) {
                    sum = Math.max(lsum, sum);
                }
            }
        }
        return sum;
    }
}

/*
Given an array nums of integers and integer k, return the maximum sum such that there exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j exist satisfying this equation, return -1.
Example 1:
Input: nums = [34,23,1,24,75,33,54,8], k = 60
Output: 58
Explanation: We can use 34 and 24 to sum 58 which is less than 60.
Example 2:
Input: nums = [10,20,30], k = 15
Output: -1
Explanation: In this case it is not possible to get a pair sum less that 15.
Constraints:
1 <= nums.length <= 100
1 <= nums[i] <= 1000
1 <= k <= 2000
 */