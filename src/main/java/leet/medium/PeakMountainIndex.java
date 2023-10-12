package leet.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PeakMountainIndex {
    public static void main(String[] args) {
        int[] arr = {0,10,5,2};
        int res = peakIndexInMountainArray(arr);
        System.out.println(res);
    }

//  binary search time: O(log n), space O(1)
    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1, mid;
        while(left < right) {
            mid = (left + right) / 2;
            if(arr[mid] < arr[mid + 1]) left = mid + 1;
            else right = mid;
        }
        return left;
    }

//    linear scan time : O(n), space : O(1)
    public static int peakIndexInMountainArray1(int[] arr) {
        int i = 0;
        while(arr[i] < arr[i+1]) i++;
        return i;
    }


    //    bad :p
    public static int peakIndexInMountainArray2(int[] arr) {
        List<Integer> li = new ArrayList<>();
        for(int a : arr) li.add(a);
        Collections.sort(li);
        int peak = li.get(arr.length-1);
        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] == peak) return i;
        }
        return -1;
    }
}
/*
An array arr is a mountain if the following properties hold:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

You must solve it in O(log(arr.length)) time complexity.



Example 1:

Input: arr = [0,1,0]
Output: 1
Example 2:

Input: arr = [0,2,1,0]
Output: 1
Example 3:

Input: arr = [0,10,5,2]
Output: 1


Constraints:

3 <= arr.length <= 10^5
0 <= arr[i] <= 10^6
arr is guaranteed to be a mountain array.
 */
