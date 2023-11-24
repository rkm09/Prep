package leet.medium;

import java.util.ArrayList;
import java.util.List;

public class MaximumDistance {
    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<>();
        int[][] arr = {{1,4},{0,5}};
        for(int[] ar : arr) {
            List<Integer> li = new ArrayList<>();
            for(int a : ar) {
              li.add(a);
            }
            arrays.add(li);
        }
        System.out.println(maxDistance(arrays));
    }

//    time: O(n), space: O(1)
    public static int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.get(0).size();
        int minElement = arrays.get(0).get(0);
        int maxElement = arrays.get(0).get(n - 1);
        int res = 0;
        for(int i = 1 ; i < arrays.size(); i++) {
            int m = arrays.get(i).size();
            int lmin = arrays.get(i).get(0);
            int lmax = arrays.get(i).get(m - 1);
            res = Math.max(res, Math.max(Math.abs(lmax - minElement),Math.abs(maxElement - lmin)));
            minElement = Math.min(minElement, lmin);
            maxElement = Math.max(maxElement, lmax);
        }
        return res;
    }
}

/*
You are given m arrays, where each array is sorted in ascending order.
You can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a - b|.
Return the maximum distance.
Example 1:
Input: arrays = [[1,2,3],[4,5],[1,2,3]]
Output: 4
Explanation: One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
Example 2:
Input: arrays = [[1],[1]]
Output: 0
Constraints:
m == arrays.length
2 <= m <= 105
1 <= arrays[i].length <= 500
-104 <= arrays[i][j] <= 104
arrays[i] is sorted in ascending order.
There will be at most 105 integers in all the arrays.
 */