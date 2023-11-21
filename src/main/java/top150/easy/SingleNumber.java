package top150.easy;

import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {2,2,3,4,4};
        System.out.println(singleNumber(nums));
    }

//    bit manipulation; time: O(n), space: O(1) meets both requirements
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for(int num : nums) {
            ans ^= num;
        }
        return ans;
    }

//    time: O(nlogn) that way not really linear def :p
    public static int singleNumberX(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0 ; i < n - 1 ; i = i+2) {
            if(nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        return nums[n-1];
    }
}

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.
Example 1:
Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1

Constraints:
1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.

Bit Manipulation:

If we take XOR of zero and some bit, it will return that bit
a ⊕ 0 = a
If we take XOR of two same bits, it will return 0
a ⊕ a = 0
a ⊕ b ⊕ a = ( a ⊕ a ) ⊕ b = 0 ⊕ b = b
So we can XOR all bits together to find the unique number.
 */