package leet.medium;

import java.util.Arrays;
import java.util.HashMap;

public class BinaryTreeFactors {
    public static void main(String[] args) {
        int[] arr = {2,4};
        int res = numFactoredBinaryTrees(arr);
        System.out.println(res);
    }

//    DP; time: O(n^2), space: O(n)
    public static int numFactoredBinaryTrees(int[] arr) {
        int MOD = 1_000_000_007;
        int len = arr.length;
        long[] dp = new long[len];
        Arrays.fill(dp, 1);
        Arrays.sort(arr);

        HashMap<Integer, Integer> index = new HashMap<>();
        for(int i = 0 ; i < len ; i++) {
            index.put(arr[i], i);
        }

        for(int i = 0 ; i < len ; i++) {
            for(int j = 0 ; j < i ; j++) {
                if(arr[i] % arr[j] == 0) {
//                    left child valid, check for right
                    int right = arr[i] / arr[j];
                    if(index.containsKey(right)) {
                        dp[i] += (dp[j] * dp[index.get(right)]) % MOD;
                    }
                }
            }
        }

        long ans = 0;
        for(long i : dp) ans += i;
        return (int) (ans % MOD);
    }
}

/*
Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.

We make a binary tree using these integers, and each number may be used for any number of times. Each non-leaf node's value should be equal to the product of the values of its children.

Return the number of binary trees we can make. The answer may be too large so return the answer modulo 10^9 + 7.

Example 1:

Input: arr = [2,4]
Output: 3
Explanation: We can make these trees: [2], [4], [4, 2, 2]
Example 2:

Input: arr = [2,4,5,10]
Output: 7
Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].


Constraints:

1 <= arr.length <= 1000
2 <= arr[i] <= 109
All the values of arr are unique.
 */