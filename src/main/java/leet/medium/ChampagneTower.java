package leet.medium;

public class ChampagneTower {
    public static void main(String[] args) {
        int poured = 2;
        int query_row = 1;
        int query_glass = 1;
        double full = champagneTower(poured, query_row, query_glass);
        System.out.println(full);
    }
    public static double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[101][101];
        tower[0][0] = poured;
        for(int r = 0 ; r <= query_row ; r++) {
            for(int c = 0 ; c <= r ; c++) {
                double qty = (tower[r][c] - 1.0) / 2.0;
                if(qty > 0) {
                    tower[r+1][c] += qty;
                    tower[r+1][c+1] += qty;
                }
            }
        }
        return Math.min(1, tower[query_row][query_glass]);
    }
}
/*
Input: poured = 1, query_row = 1, query_glass = 1
Output: 0.00000
Input: poured = 2, query_row = 1, query_glass = 1
Output: 0.50000
Input: poured = 100000009, query_row = 33, query_glass = 17
Output: 1.00000
We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses, and so on until the 100th row.  Each glass holds one cup of champagne.
Now after pouring some non-negative integer cups of champagne, return how full the jth glass in the ith row is (both i and j are 0-indexed.)
Constraints:
0 <= poured <= 109
0 <= query_glass <= query_row < 100
Simulation:
In general, if a glass has flow-through X, then Q = (X - 1.0) / 2.0 quantity of champagne will equally flow left and right.
Time: O(R^2) // O(1) as fixed size
Space: O(R^2) // O(1) fixed size
 */