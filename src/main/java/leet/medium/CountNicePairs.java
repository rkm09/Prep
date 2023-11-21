package leet.medium;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairs {
    public static void main(String[] args) {
        int[] nums = {13,10,35,24,76};
        System.out.println(countNicePairs(nums));
    }

//    time: O(n), space: O(n)
    public static int countNicePairs(int[] nums) {
        Map<Integer, Integer> hcount = new HashMap<>();
        int MOD = 1_000_000_007;
        long pairs = 0;

        for(int num : nums) {
            int diff = num - reverse(num);
            pairs += hcount.getOrDefault(diff, 0);
            pairs %= MOD;
            hcount.put(diff, hcount.getOrDefault(diff, 0) + 1);
        }
        return (int) pairs;
    }

    private static int reverse(int num){
        int revNum = 0;
        while(num > 0) {
            revNum = revNum * 10 + num % 10;
            num /= 10;
        }
        return revNum;
    }

    private static int revAlt(int x) {
        return Integer.parseInt(new StringBuilder(x+"").reverse().toString());
    }
//    first def soln TLE :p ; time: O(n^2)
    public static int countNicePairsX(int[] nums) {
        int MOD = 1_000_000_007;
        int n = nums.length;
        int count = 0;
        int[] rev = new int[n];
        for(int i = 0 ; i < n ; i++) {
            StringBuilder sb = new StringBuilder().append(nums[i]).reverse();
            rev[i] = Integer.parseInt(sb.toString());
        }
        for(int i = 0 ; i < n ; i++) {
            for(int j = i + 1; j < n ; j++) {
                int sum = (nums[i] + rev[j]) % MOD;
                int revsum = (rev[i] + nums[j]) % MOD;
                if(sum == revsum) {
                    count = (count + 1) % MOD;
                }
            }
        }
        return count;
    }
}

/*
You are given an array nums that consists of non-negative integers. Let us define rev(x) as the reverse of the non-negative integer x. For example, rev(123) = 321, and rev(120) = 21. A pair of indices (i, j) is nice if it satisfies all of the following conditions:
0 <= i < j < nums.length
nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
Return the number of nice pairs of indices. Since that number can be too large, return it modulo 109 + 7.
Example 1:
Input: nums = [42,11,1,97]
Output: 2
Explanation: The two pairs are:
 - (0,3) : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121.
 - (1,2) : 11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12.
Example 2:

Input: nums = [13,10,35,24,76]
Output: 4


Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 109
 */
