package top150.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubseq300 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums1 = {7,7,7,7,7,7,7};
        int[] nums2 = {11,12,13,14,15,6,7,8,101,18};
        System.out.println(lengthOfLIS(nums2));
    }

//    dp; time: O(n^2), space: O(n)
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i = 1; i < n ; i++) {
            for(int j = 0 ; j < i ; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int longest = 0;
        for(int num : dp) {
            longest = Math.max(longest, num);
        }
        return longest;
    }

//    another approach which only guarantees correct length but not order; time: O(n^2), space: O(n)
    public static int lengthOfLIS1(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for(int i = 1 ; i < nums.length ; i++) {
            if(nums[i] > sub.get(sub.size() - 1)) {
                sub.add(nums[i]);
            } else {
                int j = 0;
                while(nums[i] > sub.get(j)) {
                    j++;
                }
                sub.set(j, nums[i]);
            }
        }
        return sub.size();
    }

//    improvement on above with binary search; time: O(nlogn), space: O(n)
    public static int lengthOfLIS2(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for(int i = 1 ; i < nums.length ; i++) {
            if(nums[i] > sub.get(sub.size() - 1)) {
                sub.add(nums[i]);
            } else {
                int j = binarySearch(sub, nums[i]);
                sub.set(j, nums[i]);
            }
        }
        return sub.size();
    }
    
    private static int binarySearch(List<Integer> sub, int num) {
        int left = 0 ;
        int right = sub.size() - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(num == sub.get(mid)) {
                return mid;
            } else {
                if(num > sub.get(mid)) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return left;
    }
}

/*
Given an integer array nums, return the length of the longest strictly increasing
subsequence.
Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1
Constraints:
1 <= nums.length <= 2500
-104 <= nums[i] <= 104
Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */
