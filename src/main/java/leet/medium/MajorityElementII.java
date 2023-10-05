package leet.medium;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        List<Integer> li = majorityElement(nums);
        li.stream().forEach(System.out::println);
    }
    public static List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        Integer candidate1 = null;
        Integer candidate2 = null;
//        Pass 1:
        for(int num : nums) {
            if(candidate1 != null && candidate1 == num) count1++;
            else if(candidate2 != null && candidate2 == num) count2++;
            else if(count1 == 0) {
                candidate1 = num;
                count1++;
            } else if(count2 == 0) {
                candidate2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

//      Pass 2:
        List<Integer> res = new ArrayList<>();
        int majority = nums.length/3;
        count1 = 0 ; count2 = 0;
        for(int num : nums) {
            if(candidate1 != null && num == candidate1) count1++;
            else if(candidate2 != null && num == candidate2) count2++;
        }
        if(count1 > majority) res.add(candidate1);
        if(count2 > majority) res.add(candidate2);

        return res;
    }
}

/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.



Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]


Constraints:

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109


Follow up: Could you solve the problem in linear time and in O(1) space?

Complexity:

Time complexity : O(N) where N is the size of nums. We first go through nums looking for first and second potential candidates. We then count the number of occurrences for these two potential candidates in nums. Therefore, our runtime is O(N)+O(N)=O(2N)≈O(N).
Space complexity : O(1) since we only have four variables for holding two potential candidates and two counters. Even the returning array is at most 2 elements.
 */