package leet.simple;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        int numRows = 3;
        List<List<Integer>> li = generate(numRows);
        li.stream().forEach(System.out::println);
    }

//    DP
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for(int i = 1 ; i < numRows ; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(i - 1);

            row.add(1);
            for(int j = 1; j < i ; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            row.add(1);
            triangle.add(row);
        }

        return triangle;
    }

}

/*
Given an integer numRows, return the first numRows of Pascal's triangle.

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]


Constraints:

1 <= numRows <= 30


Complexity Analysis

Time complexity: O(numRows^2)

Although updating each value of triangle happens in constant time, it
is performed O(numRows^2) times.

Space complexity: O(1)

While O(numRows^2) space is used to store the output, the input and output generally do not count towards the space complexity.
 */