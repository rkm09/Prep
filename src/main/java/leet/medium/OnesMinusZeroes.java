package leet.medium;

import java.util.Arrays;

public class OnesMinusZeroes {
    public static void main(String[] args) {
        int[][] grid = {{0,1,1},{1,0,1},{0,0,1}};
        int[][] res = onesMinusZeros1(grid);
        for(int[] ar : res) {
            System.out.println(Arrays.toString(ar));
        }
    }

//    time: O(M*N), space: O(M+N)
    public static int[][] onesMinusZeros1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        int[] rowCnt = new int[m];
        int[] colCnt = new int[n];
        for(int row = 0; row < m ; row++) {
            for(int col = 0; col < n; col++) {
                rowCnt[row] += grid[row][col];
                colCnt[col] += grid[row][col];
            }
        }
        for(int row = 0 ; row < m ; row++) {
            for(int col = 0 ; col < n ; col++) {
                int diff = 2 * rowCnt[row] + 2 * colCnt[col] - m - n;
                res[row][col] = diff;
            }
        }
        return res;
    }

//    [def] brute force; TLE :| ; time: O(M*N(M+N)), space: O(1)
    public static int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        for(int row = 0 ; row < m ; row++) {
            for(int col = 0 ; col < n ; col++) {
                int rowOneCnt = 0, colOneCnt = 0, rowZeroCnt = 0, colZeroCnt = 0;
                for(int r = 0 ; r < m ; r++) {
                    if(grid[r][col] == 0) colZeroCnt++;
                    else colOneCnt++;
                }
                for(int c = 0 ; c < n ; c++) {
                    if(grid[row][c] == 0) rowZeroCnt++;
                    else rowOneCnt++;
                }
                int diff = rowOneCnt + colOneCnt - rowZeroCnt - colZeroCnt;
                res[row][col] = diff;
            }
        }
        return res;
    }
}

/*
You are given a 0-indexed m x n binary matrix grid.
A 0-indexed m x n difference matrix diff is created with the following procedure:
Let the number of ones in the ith row be onesRowi.
Let the number of ones in the jth column be onesColj.
Let the number of zeros in the ith row be zerosRowi.
Let the number of zeros in the jth column be zerosColj.
diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj
Return the difference matrix diff.
Input: grid = [[0,1,1],[1,0,1],[0,0,1]]
Output: [[0,0,4],[0,0,4],[-2,-2,2]]
Input: grid = [[1,1,1],[1,1,1]]
Output: [[5,5,5],[5,5,5]]
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 105
1 <= m * n <= 105
grid[i][j] is either 0 or 1.
 */