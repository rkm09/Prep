package leet.simple;

public class FindSpecialInteger1287 {
    public static void main(String[] args) {
        int[] arr = {1,2,2,6,6,6,6,7,10};
        System.out.println(findSpecialInteger(arr));
    }
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