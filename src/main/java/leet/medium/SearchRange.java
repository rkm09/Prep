package leet.medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SearchRange {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] res = searchRange(nums, target);
        Arrays.stream(res).forEach(System.out::println);
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        List<Integer> li = new ArrayList<>();
        for(int i : nums) li.add(i);
        int index = li.indexOf(target);
        if(index != -1) {
            res[0] = index;
            res[1] = li.lastIndexOf(target);
        }
        return res;
    }
}

/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109


 */