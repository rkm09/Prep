package leet.medium;

import java.util.Arrays;

public class ReductionOperations {
    public static void main(String[] args) {
        int[] nums = {5,1,3};
        System.out.println(reductionOperations(nums));
    }

//    time: O(nlogn), space: O(logn) sorting with quick sort variant
    public static int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int ans = 0;
        int n = nums.length;
        for(int i = 1 ; i < n ; i++) {
            if(nums[i] != nums[i-1]) {
                count++;
            }
            ans += count;
        }
        return ans;
    }
}

/*
Given an integer array nums, your goal is to make all elements in nums equal. To complete one operation, follow these steps:
Find the largest value in nums. Let its index be i (0-indexed) and its value be largest. If there are multiple elements with the largest value, pick the smallest i.
Find the next largest value in nums strictly smaller than largest. Let its value be nextLargest.
Reduce nums[i] to nextLargest.
Return the number of operations to make all elements in nums equal.

Example 1:

Input: nums = [5,1,3]
Output: 3
Explanation: It takes 3 operations to make all elements in nums equal:
1. largest = 5 at index 0. nextLargest = 3. Reduce nums[0] to 3. nums = [3,1,3].
2. largest = 3 at index 0. nextLargest = 1. Reduce nums[0] to 1. nums = [1,1,3].
3. largest = 3 at index 2. nextLargest = 1. Reduce nums[2] to 1. nums = [1,1,1].
Example 2:

Constraints:

1 <= nums.length <= 5 * 104
1 <= nums[i] <= 5 * 104

The problem description describes the following process:
Find the largest value
Decrease it to the second largest unique value
Repeat
The termination condition is when all elements are equal. However, you may notice that in the end, the elements will always be equal to the original minimum element. Thus, we can reframe the problem as "How many operations are required to reduce every number to the minimum element?

 */