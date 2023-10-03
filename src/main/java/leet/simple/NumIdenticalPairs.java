package leet.simple;

import java.util.HashMap;

public class NumIdenticalPairs {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        int res = numIdenticalPairs(nums);
        System.out.println(res);
    }

//    time: O(n), space: O(n)
    public static int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int count = 0;
        for(int num : nums) {
            count += hmap.getOrDefault(num, 0);
            hmap.put(num, hmap.getOrDefault(num,0)+1);
        }
        return count;
    }

//    time: O(n^2), space: O(1)
    public static int numIdenticalPairs1(int[] nums) {
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            for(int j = i + 1 ; j < nums.length ; j++) {
                if(nums[i] == nums[j]) count++;
            }
        }
        return count;
    }

}

/*
Given an array of integers nums, return the number of good pairs.
A pair (i, j) is called good if nums[i] == nums[j] and i < j.

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.

 */