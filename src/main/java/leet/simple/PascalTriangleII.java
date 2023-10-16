package leet.simple;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public static void main(String[] args) {
        int rowIndex = 3;
        List<Integer> li = getRow(rowIndex);
        li.stream().forEach(System.out::print);
    }


    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for(int i = 1 ; i <= rowIndex ; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(i-1);
            row.add(1);
            for(int j = 1 ; j < i ; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            row.add(1);
            triangle.add(row);
        }

        return triangle.get(rowIndex);
    }

//    TLE :|
    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for(int i = 0 ; i <= rowIndex ; i++) {
            row.add(getNum(rowIndex, i));
        }
        return row;
    }
    public static int getNum(int row, int col) {
        if(row == 0 || col == 0 || row == col)
            return 1;
        return getNum(row - 1, col - 1) + getNum(row - 1, col);
    }
}

/*
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]


Constraints:

0 <= rowIndex <= 33


Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?


 */