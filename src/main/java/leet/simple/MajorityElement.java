package leet.simple;

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        int res = majorityElement(nums);
        System.out.println(res);
    }

//    Boyer-Moore voting algo
//    If we had some way of counting instances of the majority element as +1+1+1 and instances of any other element as −1-1−1, summing them would make it obvious that the majority element is indeed the majority element.
//    time: O(n) constant exactly n times work, space: O(1) only constant additional memory
    public static int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        for(int num : nums) {
            if(count == 0) candidate = num;
            count += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }

//    sort : If the elements are sorted in monotonically increasing (or decreasing) order, the majority element can be found at index ⌊n2⌋
//    time: Sorting the array costs O(nlgn) time, so it dominates the overall runtime
//    space: O(n) or O(1) We sorted nums in place here - if that is not allowed, then we must
//    spend linear additional space on a copy of nums and sort the copy instead.
    public static int majorityElement4(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static int majorityElement5(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int majority = nums.length / 2;
        if(nums.length == 1) return nums[0];
        for(int i = 0 ; i < nums.length ; i++) {
            if(hmap.containsKey(nums[i])) {
                int value = hmap.get(nums[i]) + 1;
                if(value > majority) return nums[i];
                hmap.put(nums[i], value);
            }
            else hmap.put(nums[i],1);
        }
        return -1;
    }


}

/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109


Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
