package leet.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckArithmeticSubArrays {
    public static void main(String[] args) {
        int[] nums = {4,6,5,9,3,7};
        int[] l = {0,0,2};
        int[] r = {2,3,5};
        List<Boolean> res = checkArithmeticSubarrays(nums, l, r);
        System.out.println(res);
    }

//    sort and check; time: O(m.n.logn), space: O(n)
    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for(int i = 0 ; i < l.length ; i++) {
            int[] subArr = new int[r[i]-l[i]+1];
            for(int j = 0 ; j < subArr.length ; j++) {
                subArr[j] = nums[j + l[i]];
            }
            res.add(check(subArr));
        }
        return res;
    }
    public static boolean check(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for(int k = 2 ; k < arr.length ; k++) {
            if(arr[k] - arr[k-1] != diff) {
                return false;
            }
        }
        return true;
    }
}

/*
A sequence of numbers is called arithmetic if it consists of at least two elements, and the difference between every two consecutive elements is the same. More formally, a sequence s is arithmetic if and only if s[i+1] - s[i] == s[1] - s[0] for all valid i.
For example, these are arithmetic sequences:
1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic:
1, 1, 2, 5, 7
You are given an array of n integers, nums, and two arrays of m integers each, l and r, representing the m range queries, where the ith query is the range [l[i], r[i]]. All the arrays are 0-indexed.
Return a list of boolean elements answer, where answer[i] is true if the subarray nums[l[i]], nums[l[i]+1], ... , nums[r[i]] can be rearranged to form an arithmetic sequence, and false otherwise.
Example 1:
Input: nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
Output: [true,false,true]
Explanation:
In the 0th query, the subarray is [4,6,5]. This can be rearranged as [6,5,4], which is an arithmetic sequence.
In the 1st query, the subarray is [4,6,5,9]. This cannot be rearranged as an arithmetic sequence.
In the 2nd query, the subarray is [5,9,3,7]. This can be rearranged as [3,5,7,9], which is an arithmetic sequence.
Example 2:
Input: nums = [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10], l = [0,1,6,4,8,7], r = [4,4,9,7,9,10]
Output: [false,true,false,false,true,true]
Constraints:
n == nums.length
m == l.length
m == r.length
2 <= n <= 500
1 <= m <= 500
0 <= l[i] < r[i] < n
-105 <= nums[i] <= 105

sort:
Complexity Analysis

Given n as the length of nums and mmm as the length of l and r,
Time complexity: O(m⋅n⋅logn)

There are m queries. In the worst-case scenario, each query would have r[i] - l[i] = O(n), representing an array of size O(n).
Then, we would require O(n) to create arr, O(n⋅logn) to sort arr, and O(n) to iterate over arr.
Thus, in the worst-case scenario, each of the mmm queries costs O(n⋅logm).
Space complexity: O(n)
We create arr, which may use up to O(n) space.

 */