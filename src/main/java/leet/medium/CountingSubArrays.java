package leet.medium;

import java.util.HashMap;
import java.util.Stack;

public class CountingSubArrays {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] nums1 = {1, 3, 5, 4, 4, 6};
        long count = countSubArrays1(nums1);
        System.out.println(count);
    }

    //    DP. time complexity O(n) and space O(1)
    public static long countSubArrays(int[] nums) {
        long currSubArray = 1;
        long subArrayCnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) currSubArray++;
            else currSubArray = 1;
            subArrayCnt += currSubArray;
        }
        return subArrayCnt;
    }

//    Greedy, O(n) despite the nested loop, each element is only iterated over once as i is strictly increasing; space O(1)
//    sum of n natural numbers: n(n+1)/2 [increasing sub arrays]
    public static long countSubArrays1(int[] nums) {
        long subArrayCnt = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            long currSubArray = 1;
            while(i+1 < nums.length && nums[i] < nums[i+1]) {
                currSubArray++;
                i++;
            }
            subArrayCnt += ((currSubArray) * (currSubArray + 1)) / 2;
        }
        return subArrayCnt;
    }

}
/*
You are given an array nums consisting of positive integers.
Return the number of sub arrays of nums that are in strictly increasing order.
A sub array is a contiguous part of an array.

Input: nums = [1,3,5,4,4,6]
Output: 10
Explanation: The strictly increasing sub arrays are the following:
- Sub arrays of length 1: [1], [3], [5], [4], [4], [6].
- Sub arrays of length 2: [1,3], [3,5], [4,6].
- Sub arrays of length 3: [1,3,5].
The total number of sub arrays is 6 + 3 + 1 = 10.
Example 2:

Input: nums = [1,2,3,4,5]
Output: 15
Explanation: Every sub array is strictly increasing. There are 15 possible sub arrays that we can take.


Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 106



 */