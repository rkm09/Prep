package leet.simple;

import java.util.HashMap;
import java.util.Map;


/*
TwoSum:
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] ar = {2,7,11,15};
        int target = 9;
//        int[] res = twoSumBrute(ar, target);
        int[] res = twoSum(ar, target);
        for(int i : res) System.out.println(i);
    }

    public static int[] twoSum(int[] nums, int target) {
//        time: O(n), space: O(n)
        Map<Integer, Integer> seen = new HashMap<>();
        int key = 0;
//        current + y = target --> y = target - current --> check for y's presence in map
        for(int i = 0 ; i < nums.length ; i++) {
            key = target - nums[i];
            if(seen.containsKey(key)) return new int[] {i, seen.get(key)};
            else seen.put(nums[i], i);
        }
        return null;
    }

    public static int[] twoSumBrute(int[] nums, int target) {
//        time: O(n^2), space: O(1)
        int[] res = {-1,-1};
        for(int i = 0 ; i < nums.length ; i++) {
            for(int j = i+1 ; j < nums.length ; j++) {
                if(nums[i] + nums[j] == target) {
                    res[0] = i; res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }
}
