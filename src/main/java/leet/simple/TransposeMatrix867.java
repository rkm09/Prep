package leet.simple;

import java.util.Arrays;

public class TransposeMatrix867 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix1 = {{1,2,3},{4,5,6}};
        int[][] res = transpose(matrix1);
        for(int[] ar : res) {
            System.out.println(Arrays.toString(ar));
        }
    }
    public static int[][] transpose(int[][] matrix) {
        int row = matrix.length;     
        int col = matrix[0].length;
        int[][] res = new int[col][row];
        for(int i = 0 ; i < col ; i++) {
            for(int j = 0 ; j < row ; j++) {
                res[i][j] = matrix[j][i];
            }
        }
        return res;
    }
}

/*
Given a 2D integer array matrix, return the transpose of matrix.
The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
Example 2:
Input: matrix = [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]
Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 1000
1 <= m * n <= 105
-109 <= matrix[i][j] <= 109
 */