package leet.simple;

import java.util.Arrays;

public class ImageSmoother661 {
    public static void main(String[] args) {
        int[][] img = {{1,1,1}, {1,0,1}, {1,1,1}};
        int[][] res = imageSmoother2(img);
        for(int[] row : res) {
            System.out.println(Arrays.toString(row));
        }
    }
//    1 1 1
//    1 0 1
//    1 1 1
//    bit manipulation; time: O(m.n), space: O(1); faster;
    public static int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        for(int row = 0 ; row < m ; row++) {
            for(int col = 0 ; col < n ; col++) {
                int sum = 0;
                int count = 0;
                for(int r = row - 1; r <= row + 1; r++) {
                    for(int c = col - 1 ; c <= col + 1 ; c++) {
                        if(r >= 0 && r < m && c >= 0 && c < n) {
                            sum += img[r][c] & 255;
                            count += 1;
                        }
                    }
                }
                img[row][col] |= (sum / count) << 8;
            }
        }
        for(int row = 0 ; row < m ; row++) {
            for(int col = 0 ; col < n ; col++) {
                img[row][col] >>= 8;
            }
        }
        return img;
    }

//    basic, space optimized; time: O(mn), space: O(1)
    public static int[][] imageSmoother2(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        for(int row = 0 ; row < m ; row++) {
            for(int col = 0 ; col < n ; col++) {
                int sum = 0;
                int count = 0;
                for(int r = row - 1 ; r <= row + 1 ; r++) {
                    for(int c = col - 1 ; c <= col + 1 ; c++) {
                        if(r >= 0 && r < m && c >= 0 && c < n) {
                            sum += img[r][c] % 256;
                            count += 1;
                        }
                    }
                }
                img[row][col] += (sum / count) * 256;
            }
        }
        for(int row = 0 ; row < m ; row++) {
            for(int col = 0 ; col < n ; col++) {
                img[row][col] /= 256;
            }
        }
        return img;
    }

//    basic; time: O(mn), space: O(mn)
    public static int[][] imageSmoother1(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] smoothened = new int[m][n];
        for(int row = 0 ; row < m ; row++) {
            for(int col = 0 ; col < n ; col++) {
                int sum = 0;
                int count = 0;
                for(int r = row - 1 ; r <= row + 1 ; r++) {
                    for(int c = col - 1 ; c <= col + 1; c++) {
                        if(r >= 0 && r < m && c >= 0 && c < n) {
                            sum += img[r][c];
                            count += 1;
                        }
                    }
                }
                smoothened[row][col] = (sum / count);
            }
        }
        return smoothened;
    }
}
/*
An image smoother is a filter of the size 3 x 3 that can be applied to each cell of an image by rounding down the average of the cell and the eight surrounding cells (i.e., the average of the nine cells in the blue smoother). If one or more of the surrounding cells of a cell is not present, we do not consider it in the average
Given an m x n integer matrix img representing the grayscale of an image, return the image after applying the smoother on each cell of it.
Input: img = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[0,0,0],[0,0,0],[0,0,0]]
Explanation:
For the points (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the points (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0
Input: img = [[100,200,100],[200,50,200],[100,200,100]]
Output: [[137,141,137],[141,138,141],[137,141,137]]
Explanation:
For the points (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
For the points (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
For the point (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138
Constraints:
m == img.length
n == img[i].length
1 <= m, n <= 200
0 <= img[i][j] <= 255

Key notes:
1-1 correspondence between:

*** Bitwise AND(&) with 255 == modulo by 256 (extract)
*** Leftshift (<<) by 8 bits == multiply by 256 (move)
*** Bitwise OR(|) with smoothened img values == ADD smoothened img values to img (embed)
*** Rightshift (>>) by 8 bits == divide by 256 (move)
 */
