package leet.medium;

import java.util.Arrays;

public class LargestSubMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{0,0,1},{1,1,1},{1,0,1}};
        System.out.println(largestSubmatrix1(matrix));
    }

//    sort; time: O(m * nlogn), space: O(m) [as we did not modify the input]
    public static int largestSubmatrix1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        int[] prevRow = new int[n];
        for(int row = 0 ; row < m ; row++) {
            int[] currRow = matrix[row].clone();
            for(int col = 0 ; col < n ; col++) {
                if(currRow[col] != 0) {
                    currRow[col] += prevRow[col];
                }
            }
            int[] sortedRow = currRow.clone();
            Arrays.sort(sortedRow);
            for(int i = 0 ; i < n ; i++) {
                ans = Math.max(ans, sortedRow[i] * (n - i));
            }
            prevRow = currRow;
        }
        return ans;
    }

//    sort; time: O(m * nlogn), space: O(m*n) [as we did in place modification (not recommended)]
    public static int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        for(int row = 0 ; row < m ; row++) {
            for(int col = 0 ; col < n ; col++) {
                if(matrix[row][col] != 0 & row > 0) {
                    matrix[row][col] += matrix[row-1][col];
                }
            }
            int[] currRow = matrix[row].clone();
            Arrays.sort(currRow);
            for(int i = 0 ; i < n ; i++) {
                ans = Math.max(ans, currRow[i] * (n-i));
            }
        }
        return ans;
    }
}

/*
You are given a binary matrix matrix of size m x n, and you are allowed to rearrange the columns of the matrix in any order.
Return the area of the largest submatrix within matrix where every element of the submatrix is 1 after reordering the columns optimally.
Input: matrix = [[0,0,1],[1,1,1],[1,0,1]]
Output: 4
Explanation: You can rearrange the columns as shown above.
The largest submatrix of 1s, in bold, has an area of 4.
Input: matrix = [[1,0,1,0,1]]
Output: 3
Explanation: You can rearrange the columns as shown above.
The largest submatrix of 1s, in bold, has an area of 3.
Example 3:
Input: matrix = [[1,1,0],[1,0,1]]
Output: 2
Explanation: Notice that you must rearrange entire columns, and there is no way to make a submatrix of 1s larger than an area of 2.
Constraints:
m == matrix.length
n == matrix[i].length
1 <= m * n <= 105
matrix[i][j] is either 0 or 1.

sort:

Note that in Java, we can't conveniently sort int[] in descending order, so we sort it in ascending order and consider the base to the right of each column instead. For each column i, every column to its right has a height greater than or equal to the current height. Thus, we can treat the number of columns n - i as the base to form a submatrix with the current height.
Now, hopefully, the idea is clear: at each column col, we know every column to its left has a height greater than or equal to the current height. Thus, we can treat the number of columns col + 1 as the base to form a submatrix with the current height.
Complexity Analysis
Given m as the number of rows in matrix and nnn as the number of columns in matrix,
Time complexity: O(m⋅n⋅logn)
We iterate over m rows. For each row, we update the values which costs O(n). Then, we sort the row, which costs O(n⋅logn). Finally, we iterate over the row to calculate submatrix areas, which costs O(n).
Overall, each of the mmm iterations costs O(n⋅logn).
Space complexity: O(m⋅n)
Although we are only allocating currRow which has a size of O(n), we are modifying matrix. It is generally considered a bad practice to modify the input and when you do, you should count it as part of the space complexity.

 */