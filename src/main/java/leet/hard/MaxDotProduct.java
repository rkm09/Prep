package leet.hard;

public class MaxDotProduct {
    public static void main(String[] args) {
        int[] nums1 = {2,1,-2,5};
        int[] nums2 = {3,0,-6};
        int res = maxDotProduct(nums1, nums2);
        System.out.println(res);
    }
    public static int maxDotProduct(int[] nums1, int[] nums2) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for(int num : nums1) {
            firstMax = Math.max(firstMax, num);
            firstMin = Math.min(firstMin, num);
        }

        for(int num : nums2) {
            secondMax = Math.max(secondMax, num);
            secondMin = Math.min(secondMin, num);
        }

        if(firstMax < 0 && secondMin > 0)
            return firstMax * secondMin;

        if(secondMax < 0 && firstMin > 0)
            return secondMax * firstMin;

        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for(int i = nums1.length - 1 ; i >= 0 ; i--) {
            for(int j = nums2.length - 1 ; j >= 0; j--) {
                int use = nums1[i] * nums2[j] + dp[i+1][j+1];
                dp[i][j] = Math.max(use, Math.max(dp[i][j+1], dp[i+1][j]));
            }
        }

        return dp[0][0];
    }
}

/*
Given two arrays nums1 and nums2.

Return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.

A subsequence of a array is a new array which is formed from the original array by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, [2,3,5] is a subsequence of [1,2,3,4,5] while [1,5,3] is not).



Example 1:

Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
Output: 18
Explanation: Take subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2.
Their dot product is (2*3 + (-2)*(-6)) = 18.
Example 2:

Input: nums1 = [3,-2], nums2 = [2,-6,7]
Output: 21
Explanation: Take subsequence [3] from nums1 and subsequence [7] from nums2.
Their dot product is (3*7) = 21.
Example 3:

Input: nums1 = [-1,-1], nums2 = [1,1]
Output: -1
Explanation: Take subsequence [-1] from nums1 and subsequence [1] from nums2.
Their dot product is -1.


Constraints:

1 <= nums1.length, nums2.length <= 500
-1000 <= nums1[i], nums2[i] <= 1000

Complexity Analysis

Given nnn as the length of nums1 and mmm as the length of nums2,

Time complexity: O(n⋅m)

We only calculate each state (i, j) once - one state per inner for loop iteration. There are n⋅m states of (i, j). To calculate a state, we simply take the maximum of three options, which costs O(1)O(1)O(1).

Space complexity: O(n⋅m)

The table dp takes O(n⋅m)

Bottom up DP:
Algorithm

Check the following special cases:
If max(nums1) < 0 and min(nums2) > 0, then return max(nums1) * min(nums2).
If min(nums1) > 0 and max(nums2) < 0, then return min(nums1) * max(nums2).
Create a 2d table dp of size (nums1.length + 1) * (nums2.length + 1).
Iterate i from nums1.length - 1 until 0:
Iterate j from nums2.length - 1 until 0:
Set use = nums1[i] * nums2[j] + dp[i + 1][j + 1]. This is the dot product from using the current numbers.
Find maximum of use, dp[i + 1][j], dp[i][j + 1]. Store it in dp[i][j].
Return dp[0][0], the answer to the original problem.
 */