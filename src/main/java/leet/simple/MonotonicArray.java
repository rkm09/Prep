package leet.simple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class MonotonicArray {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        int[] nums1 = {3,1,9};
        boolean res = isMonotonic(nums1);
        System.out.println(res);
    }
    public static boolean isMonotonic(int[] nums) {
        int first = nums[0];
        int last = nums[nums.length-1];
        boolean inc = first < last ? true : false;
        for(int i = 0 ; i < nums.length-1 ; i++) {
            if(inc && nums[i] > nums[i+1]) return false;
            else if(!inc && nums[i] < nums[i+1]) return false;
        }
        return true;
    }
}

/*
An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
Given an integer array nums, return true if the given array is monotonic, or false otherwise.

Input: nums = [1,2,2,3]
Output: true

Input: nums = [6,5,4,4]
Output: true

Input: nums = [1,3,2]
Output: false

Constraints:

1 <= nums.length <= 10^5
-10^5 <= nums[i] <= 10^5

Complexity:
Time: O(N)
Space: O(1)
 */