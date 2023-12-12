package leet.simple;

import java.util.Arrays;

public class MaximumProduct1464 {
    public static void main(String[] args) {
        int[] nums = {3,4,5,2};
        System.out.println(maxProduct1(nums));
    }

//    track second biggest; time: O(n), space: O(1)
    public static int maxProduct1(int[] nums) {
        int biggest = 0 ;
        int secondBiggest = 0;
        for(int num : nums) {
            if(num > biggest) {
                secondBiggest = biggest;
                biggest = num;
            } else {
                secondBiggest = Math.max(secondBiggest, num);
            }
        }
        return (biggest - 1) * (secondBiggest - 1);
    }

//    [def]; time: O(nlogn), space: O(logn)
    public static int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int x = nums[nums.length - 1];
        int y = nums[nums.length - 2];
        return (x-1) * (y-1);
    }
}
/*
Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
Example 1:
Input: nums = [3,4,5,2]
Output: 12
Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.
Example 2:
Input: nums = [1,5,4,5]
Output: 16
Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
Example 3:
Input: nums = [3,7]
Output: 12
Constraints:
2 <= nums.length <= 500
1 <= nums[i] <= 10^3
 */
