package leet.medium;

import java.util.Arrays;

public class MaxWidthOfVertical1637 {
    public static void main(String[] args) {
        int[][] points = {{8,7},{9,9},{7,4},{9,7}};
        System.out.println(maxWidthOfVerticalArea(points));
    }
//    [def];
    public static int maxWidthOfVerticalArea(int[][] points) {
        int m = points.length;
        int[] xcoor = new int[m];
        int k = 0;
        for(int[] point : points) {
            xcoor[k++] = point[0];
        }
        Arrays.sort(xcoor);
        int max = Integer.MIN_VALUE;
        for(int i = 1 ; i < xcoor.length ; i++) {
            int diff = xcoor[i] - xcoor[i-1];
            max = Math.max(max, diff);
        }
        return max;
    }
}

/*
Given n points on a 2D plane where points[i] = [xi, yi], Return the widest vertical area between two points such that no points are inside the area.
A vertical area is an area of fixed-width extending infinitely along the y-axis (i.e., infinite height). The widest vertical area is the one with the maximum width.
Note that points on the edge of a vertical area are not considered included in the area.
Input: points = [[8,7],[9,9],[7,4],[9,7]]
Output: 1
Explanation: Both the red and the blue area are optimal.
Example 2:
Input: points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
Output: 3
Constraints:
n == points.length
2 <= n <= 105
points[i].length == 2
0 <= xi, yi <= 109
 */