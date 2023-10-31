package leet.medium;

import java.util.Arrays;


public class FindArray {
    public static void main(String[] args) {
        int[] pref = {5,2,0,3,1};
        int[] arr = findArray(pref);
        System.out.println(Arrays.toString(arr));
    }

//    XOR props; time: O(n), space: O(n)
    public static int[] findArray(int[] pref) {
        int n = pref.length;
        int[] arr = new int[n];
        arr[0] = pref[0];
        for(int i = 1 ; i < n ; i++) {
            arr[i] = pref[i] ^ pref[i-1];
        }
        return arr;
    }
}
/*
You are given an integer array pref of size n. Find and return the array arr of size n that satisfies:

pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
Note that ^ denotes the bitwise-xor operation.

It can be proven that the answer is unique.

Example 1:

Input: pref = [5,2,0,3,1]
Output: [5,7,2,3,2]
Explanation: From the array [5,7,2,3,2] we have the following:
- pref[0] = 5.
- pref[1] = 5 ^ 7 = 2.
- pref[2] = 5 ^ 7 ^ 2 = 0.
- pref[3] = 5 ^ 7 ^ 2 ^ 3 = 3.
- pref[4] = 5 ^ 7 ^ 2 ^ 3 ^ 2 = 1.
Example 2:

Input: pref = [13]
Output: [13]
Explanation: We have pref[0] = arr[0] = 13.


Constraints:

1 <= pref.length <= 105
0 <= pref[i] <= 106

An important property of XOR that we can use to solve this problem is a ^ a = 0, i.e. the XOR of two same integers is equal to 0. The value in the array pref at index i is equal to arr[0] ^ arr[1] ^ ... ^ arr[i], and the value in the index i + 1 is equal to arr[0] ^ arr[1] ^ ... ^ arr[i] ^ arr[i + 1].
Note that we have also used the XOR Associative & Commutative properties while rearranging the expression in the above diagram to come at the result.

pref[i] = arr[0]^arr[1]...arr[i];
pref[i+1] = arr[0]^arr[1]^arr[2]...arr[i]^arr[i+1]
every other term turns arr[0]^arr[0] = 0 and so what remains is :
pref[i] ^ pref[i+1] = (arr[0]^arr[1]...arr[i])^(arr[0]^arr[1]^arr[2]...arr[i]^arr[i+1]);
Associative & Commutative properties =>
pref[i] ^ pref[i+1] = arr[i+1] + 0..0;
 */
