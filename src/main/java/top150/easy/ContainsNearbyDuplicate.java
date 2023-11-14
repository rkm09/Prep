package top150.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println(containsNearbyDuplicate1(nums, k));
    }

//    time: O(n), space: O(min(n,k))
    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> hset = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++) {
            if(hset.contains(nums[i])) {
                return true;
            }
            hset.add(nums[i]);
            if(hset.size() > k) {
                hset.remove(nums[i-k]);
            }
        }
        return false;
    }

//    our default; time: O(n), space: O(n)
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++) {
            if(hmap.containsKey(nums[i])) {
                int diff = i - hmap.get(nums[i]);
                if(diff <= k) {
                    return true;
                }
            }
            hmap.put(nums[i], i);
        }
        return false;
    }
}

/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false


Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
 */