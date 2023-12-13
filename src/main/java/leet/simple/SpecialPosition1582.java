package leet.simple;

public class SpecialPosition1582 {
    public static void main(String[] args) {
        int[][] mat = {{1,0,0},{0,0,1},{1,0,0}};
        System.out.println(numSpecial1(mat));
    }

//    precompute; time: O(m*n), space: O(m+n)
    public static int numSpecial1(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        int ans = 0;
        for(int row = 0 ; row < m ; row++) {
            for(int col = 0 ; col < n ; col++) {
                if(mat[row][col] == 1) {
                    rowCount[row]++;
                    colCount[col]++;
                }
            }
        }
        for(int row = 0 ; row < m ; row++) {
            for(int col = 0 ; col < n ; col++) {
                if(mat[row][col] == 1) {
                    if(rowCount[row] == 1 && colCount[col] == 1) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

//    brute force; time: O(m*n(m+n)), space: O(1)
    public static int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;
        for(int row = 0 ; row < m ; row++) {
            for(int col = 0 ; col < n ; col++) {
                if(mat[row][col] == 0) {
                    continue;
                }
                boolean good = true;
                for(int r = 0 ; r < m ; r++) {
                    if(r != row && mat[r][col] == 1) {
                        good = false;
                        break;
                    }
                }
                for(int c = 0 ; c < n ; c++) {
                    if(c != col && mat[row][c] == 1) {
                        good = false;
                        break;
                    }
                }
                if(good) {
                    ans++;
                }
            }
        }
        return ans;
    }
}

/*
Given an m x n binary matrix mat, return the number of special positions in mat.
A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).
Input: mat = [[1,0,0],[0,0,1],[1,0,0]]
Output: 1
Explanation: (1, 2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.
Input: mat = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
Explanation: (0, 0), (1, 1) and (2, 2) are special positions.
Constraints:
m == mat.length
n == mat[i].length
1 <= m, n <= 100
mat[i][j] is either 0 or 1.
 */