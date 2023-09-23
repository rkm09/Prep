package leet.simple;

import java.util.Arrays;

public class CountBits {
    public static void main(String[] args) {
        int[] res = countBits1(2);
        Arrays.stream(res).forEach(s-> System.out.println(s));
    }
    public static int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i = 0 ; i <= n ; i++) {
            res[i] = getBitCount(i);
        }
        return res;
    }
    public static int getBitCount(int c) {
        int count = 0;
        while(c != 0) {
            count++;
            c = c & (c-1);
        }
        return count;
    }

//    DP & last bit
    public static int[] countBits1(int n) {
        int[] res = new int[n+1];
        for(int i = 1 ; i <= n ; i++) {
            res[i] = res[i & (i-1)] + 1;
        }
        return res;
    }

}
/*
Input: n = 2
Output: [0,1,1]
Input: n = 5
Output: [0,1,1,2,1,2]

Time complexity: O(n⋅log n) For each integer x, in the worst case, we need to perform O(log n) operations, since the number of bits in x equals to log x + 1 and all the bits can be equal to 111. However, on average, each bit will be set n/2 times, so for each integer x we will perform log (x)/2 operations
Space complexity: O(1). Since the output array does not count towards the space complexity.

For DP approach:
Time : O(n)
Space: O(1)
 */