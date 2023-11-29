package leet.medium;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0};
        System.out.println(findMaxConsecutiveOnes1(nums));
    }

//    sliding window; time: O(n), space: O(1)
    public static int findMaxConsecutiveOnes1(int[] nums) {
        int longestSequence = 0;
        int n = nums.length;
        int left = 0, right = 0;
        int numOfZeroes = 0;
        while(right < n) {
            if(nums[right] == 0) {
                numOfZeroes++;
            }
            while(numOfZeroes == 2) {
                if(nums[left] == 0) {
                    numOfZeroes--;
                }
                left++;
            }
            longestSequence = Math.max(longestSequence, right - left + 1);
            right++;
        }
        return longestSequence;
    }

//    brute force; time: O(n^2), space: O(1)
    public static int findMaxConsecutiveOnes(int[] nums) {
        int longestSequence = 0;
        int n = nums.length;
        for(int left = 0 ; left < n ; left++) {
            int numOfZeroes = 0;
            for(int right = left ; right < n ; right++) {
                if(nums[right] == 0) {
                    numOfZeroes++;
                }
                if(numOfZeroes <= 1) {
                    longestSequence = Math.max(longestSequence, right - left + 1);
                }
            }
        }
        return longestSequence;
    }
}

/*
Given a binary array nums, return the maximum number of consecutive 1's in the array if you can flip at most one 0.
Example 1:
Input: nums = [1,0,1,1,0]
Output: 4
Explanation:
- If we flip the first zero, nums becomes [1,1,1,1,0] and we have 4 consecutive ones.
- If we flip the second zero, nums becomes [1,0,1,1,1] and we have 3 consecutive ones.
The max number of consecutive ones is 4.
Example 2:
Input: nums = [1,0,1,1,0,1]
Output: 4
Explanation:
- If we flip the first zero, nums becomes [1,1,1,1,0,1] and we have 4 consecutive ones.
- If we flip the second zero, nums becomes [1,0,1,1,1,1] and we have 4 consecutive ones.
The max number of consecutive ones is 4.
Constraints:
1 <= nums.length <= 105
nums[i] is either 0 or 1.
Follow up: What if the input numbers come in one by one as an infinite stream? In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently?
Follow up infinite stream - Maintain the 'left', 'right' and 'last seen zero'. As soon as one encounters another 0 in stream, record the maxLength; make leftIndex = zeroIndex + 1, and set zeroIndex = right = curIndex. Again continue processing the stream.
 */