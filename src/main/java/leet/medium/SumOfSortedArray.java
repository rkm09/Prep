package leet.medium;

import java.util.Arrays;

public class SumOfSortedArray {
    public static void main(String[] args) {
        int[] nums = {2,3,5};
        System.out.println(Arrays.toString(getSumAbsoluteDifferences1(nums)));
    }

//    on the fly prefix sum; time: O(n), space: O(1)
    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }
        int leftSum = 0;
        int[] ans = new int[n];
        for(int i = 0 ; i < n ; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            int leftCount = i;
            int rightCount = n - 1 - i;
            int leftTotal = leftCount * nums[i] - leftSum;
            int rightTotal = rightSum - rightCount * nums[i];
            ans[i] = leftTotal + rightTotal;
            leftSum += nums[i];
        }
        return ans;
    }

//    prefix sum; time: O(n), space: O(n) ;
    public static int[] getSumAbsoluteDifferences1(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i = 1 ; i < n ; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        int[] ans = new int[n];
        for(int i = 0 ; i < n ; i++) {
            int leftSum = prefixSum[i] - nums[i];
            int rightSum = prefixSum[n-1] - prefixSum[i];
            int leftCount = i;
            int rightCount = n - 1 - i;
            int leftTotal = nums[i] * leftCount - leftSum;
            int rightTotal = rightSum - nums[i] * rightCount;
            ans[i] = leftTotal + rightTotal;
        }
        return ans;
    }
}
/*
You are given an integer array nums sorted in non-decreasing order.
Build and return an integer array result with the same length as nums such that result[i] is equal to the summation of absolute differences between nums[i] and all the other elements in the array.
In other words, result[i] is equal to sum(|nums[i]-nums[j]|) where 0 <= j < nums.length and j != i (0-indexed).
Example 1:
Input: nums = [2,3,5]
Output: [4,3,5]
Explanation: Assuming the arrays are 0-indexed, then
result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4,
result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3,
result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5.
Example 2:
Input: nums = [1,4,6,8,10]
Output: [24,15,13,15,21]
Constraints:
2 <= nums.length <= 105
1 <= nums[i] <= nums[i + 1] <= 104
 */
