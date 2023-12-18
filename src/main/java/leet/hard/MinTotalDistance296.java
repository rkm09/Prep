package leet.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinTotalDistance296 {
    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        int res = minTotalDistance1(grid);
        System.out.println(res);
    }

//    1 0 0 0 1
//    0 0 0 0 0
//    0 0 1 0 0

//    median but without explicit sorting; time: O(mn), space: O(mn)
    public static int minTotalDistance1(int[][] grid) {
        List<Integer> rows = collectRows(grid);
        List<Integer> cols = collectCols(grid);
        int row = rows.get(rows.size() / 2);
        int col = cols.get(cols.size() / 2);
        System.out.println(rows);
        System.out.println(cols);
        return minDistance1D(rows, row) + minDistance1D(cols, col);
    }

    private static List<Integer> collectRows(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        for(int row = 0 ; row < grid.length ; row++) {
            for(int col = 0 ; col < grid[0].length ; col++) {
                if(grid[row][col] == 1) {
                    rows.add(row);
                }
            }
        }
        return rows;
    }

    private static List<Integer> collectCols(int[][] grid) {
        List<Integer> cols = new ArrayList<>();
        for(int col = 0 ; col < grid[0].length ; col++) {
            for(int row = 0 ; row < grid.length ; row++) {
                if(grid[row][col] == 1) {
                    cols.add(col);
                }
            }
        }
        return cols;
    }

//    median; time: O(mnlogmn), space: O(mn)
    public static int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for(int row = 0 ; row < grid.length ; row++) {
            for(int col = 0 ; col < grid[0].length ; col++) {
                if(grid[row][col] == 1) {
                    rows.add(row);
                    cols.add(col);
                }
            }
        }
        int row = rows.get(rows.size() / 2);
        Collections.sort(cols);
        int col = cols.get(cols.size() / 2);
        return minDistance1D(rows, row) + minDistance1D(cols, col);
    }
    private static int minDistance1D(List<Integer> points, int origin) {
        int distance = 0;
        for(int point : points) {
            distance += Math.abs(point - origin);
        }
        return distance;
    }
}

/*
Given an m x n binary grid grid where each 1 marks the home of one friend, return the minimal total travel distance.
The total travel distance is the sum of the distances between the houses of the friends and the meeting point.
The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
Input: grid = [[1,0,0,0,1],[0,0,0,0,0],[0,0,1,0,0]]
Output: 6
Explanation: Given three friends living at (0,0), (0,4), and (2,2).
The point (0,2) is an ideal meeting point, as the total travel distance of 2 + 2 + 2 = 6 is minimal.
So return 6.
Example 2:
Input: grid = [[1,1]]
Output: 1
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 200
grid[i][j] is either 0 or 1.
There will be at least two friends in the grid.
 */