package leet.medium;

import java.util.Stack;

public class Find132Pattern {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] nums1 = {3,1,4,2};
        boolean res = find132pattern4(nums1);
        System.out.println(res);
    }

//    Stack; time: O(n), space O(n)
    public static boolean find132pattern4(int[] nums) {
//        min array manages i, nums fixed with j, and stack represents k
        if(nums.length < 3) return false;
        Stack<Integer> stack = new Stack<>();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for(int i = 1 ; i < nums.length ; i++)
            min[i] = Math.min(min[i-1], nums[i]);
        for(int j = nums.length - 1 ; j >= 0 ; j--) {
            if(nums[j] > min[j]) {
                while(!stack.empty() && stack.peek() <= min[j])
                    stack.pop();
                if(!stack.empty() && stack.peek() < nums[j]) return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }

//    Better brute force O(n2) space O(1) (time limit exceeded!)
    public static boolean find132pattern5(int[] nums) {
        int minI = Integer.MAX_VALUE;
        for(int j = 0 ; j < nums.length - 1 ; j++) {
            minI = Math.min(minI, nums[j]);
            for(int k = j + 1 ; k < nums.length ; k++) {
                if(nums[k] < nums[j] && minI < nums[k]) return true;
            }
        }
        return false;
    }

//    Brute force : (time limit exceeded!) O(n3) space O(1)
    public static boolean find132pattern6(int[] nums) {
        for(int i = 0 ; i < nums.length - 2; i++) {
            for(int j = i+1 ; j < nums.length - 1 ; j++) {
                for(int k = j+1 ; k < nums.length ; k++) {
                    if(nums[k] > nums[i] && nums[k] < nums[j]) return true;
                }
            }
        }
        return false;
    }
}

/*
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
Return true if there is a 132 pattern in nums, otherwise, return false.

Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.

Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].

Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].

Constraints:
n == nums.length
1 <= n <= 2 * 10^5
-10^9 <= nums[i] <= 10^9



 */