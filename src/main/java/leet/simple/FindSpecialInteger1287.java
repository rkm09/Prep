package leet.simple;

import java.util.HashMap;
import java.util.Map;

public class FindSpecialInteger1287 {
    public static void main(String[] args) {
        int[] arr = {1,2,2,6,6,6,6,7,10};
        System.out.println(findSpecialInteger(arr));
    }

//    count ahead; time: O(n), space: O(1)
    public static int findSpecialInteger2(int[] arr) {
        int n = arr.length, size = n / 4;
        for(int i = 0 ; i < n - size ; i++) {
            if(arr[i] == arr[i + size]) {
                return arr[i];
            }
        }
        return -1;
    }

//    [def]; time: O(n), space: O(1) ; faster
    public static int findSpecialInteger(int[] arr) {
        int count = 1, curr = arr[0];
        int n = arr.length, times = n / 4;
        if(n == 1) return arr[0];
        for(int i = 1 ; i < n ; i++) {
            if(curr == arr[i]) {
                count++;
                if(count > times) return curr;
            } else {
                count = 1;
                curr = arr[i];
            }
        }
        return -1;
    }

//    hashmap; time : O(n), space: O(n) ; slowest
    public static int findSpecialInteger1(int[] arr) {
        Map<Integer, Integer> count = new HashMap();
        int times = arr.length / 4;
        for(int i = 0 ; i < arr.length ; i++) {
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
            if(count.get(arr[i]) > times) {
                return arr[i];
            }
        }
        return -1;
    }
}

/*
Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time, return that integer.
Example 1:
Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6
Example 2:
Input: arr = [1,1]
Output: 1
Constraints:
1 <= arr.length <= 104
0 <= arr[i] <= 105
 */