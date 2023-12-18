package leet.simple;

import java.util.Arrays;

public class MaxProductDifference1913 {
    public static void main(String[] args) {
        int[] nums = {5,6,2,7,4};
        System.out.println(maxProductDifference1(nums));
    }

//    track pointers; time: O(n), space: O(1)
    public static int maxProductDifference1(int[] nums) {
        int max = 0, secondMax = 0, min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for(int num : nums) {
            if(num < max) {
                if(num > secondMax) {
                    secondMax = num;
                }
            } else {
                secondMax = max;
                max = num;
            }
            if(num > min) {
                if(num < secondMin) {
                    secondMin = num;
                }
            } else {
                secondMin = min;
                min = num;
            }
        }
        return max * secondMax - min * secondMin;
    }

//    sort; time: O(nlogn), space: O(1)
    public static int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return (nums[n-1] * nums[n-2] - nums[1] * nums[0]);
    }
}

/*
The product difference between two pairs (a, b) and (c, d) is defined as (a * b) - (c * d).
For example, the product difference between (5, 6) and (2, 7) is (5 * 6) - (2 * 7) = 16.
Given an integer array nums, choose four distinct indices w, x, y, and z such that the product difference between pairs (nums[w], nums[x]) and (nums[y], nums[z]) is maximized.
Return the maximum such product difference.
Example 1:
Input: nums = [5,6,2,7,4]
Output: 34
Explanation: We can choose indices 1 and 3 for the first pair (6, 7) and indices 2 and 4 for the second pair (2, 4).
The product difference is (6 * 7) - (2 * 4) = 34.
Example 2:
Input: nums = [4,2,5,9,7,4,8]
Output: 64
Explanation: We can choose indices 3 and 6 for the first pair (9, 8) and indices 1 and 5 for the second pair (2, 4).
The product difference is (9 * 8) - (2 * 4) = 64.
Constraints:
4 <= nums.length <= 104
1 <= num <= 104
 */