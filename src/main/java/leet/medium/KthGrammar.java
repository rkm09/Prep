package leet.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthGrammar {
    public static void main(String[] args) {
        int n = 2, k = 2;
        int res = kthGrammar2(n, k);
        System.out.println(res);
    }

//    Binary Tree Traversal; time: O(n), space: O(n) :: with each recursive call we reduce n by 1
    public static int kthGrammar(int n, int k) {
        return depthFirstSearch(n, k, 0);
    }
    public static int depthFirstSearch(int n, int k, int rootval) {
        if(n == 1) return rootval;
        int totalNodes = (int) Math.pow(2, n-1);
        if(k > totalNodes / 2) {
            int nextRootVal = (rootval == 0) ? 1 : 0;
            return depthFirstSearch(n - 1, k - (totalNodes / 2), nextRootVal);
        } else {
            int nextRootVal = (rootval == 0) ? 0 : 1;
            return depthFirstSearch(n - 1, k, nextRootVal);
        }
    }

//    Recursion:: complexity same
    public static int kthGrammar1(int n, int k) {
       return recursion(n, k);
    }
    public static int recursion(int n, int k) {
        if(n == 1) return 0;
        int totalCount = (int) Math.pow(2, n - 1);
        int halfCount = totalCount / 2;

        if(k > halfCount) {
            return 1 - recursion(n-1, k - halfCount);
        }
        return recursion(n-1, k);
    }

//    Recursion to iteration:: time: O(n), space: O(1)
    public static int kthGrammar2(int n, int k) {
        if(n == 1) return 0;
        int symbol = 1;
        for(int currRow = n ; currRow > 1 ; --currRow) {
            int totalCount = (int) Math.pow(2, currRow - 1);
            int halfCount = totalCount / 2;

            if (k > halfCount) {
                symbol = 1 - symbol;
                k -= halfCount;
            }
        }
        if(symbol != 0) return 0;
        return 1;
    }
//    Math; time: O(logk), space: O(1)
    public int kthGrammar3(int n, int k) {
        int count = Integer.bitCount(k-1);
        return count % 2 == 0 ? 0 : 1;
    }
}

/*
We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.

Example 1:

Input: n = 1, k = 1
Output: 0
Explanation: row 1: 0
Example 2:

Input: n = 2, k = 1
Output: 0
Explanation:
row 1: 0
row 2: 01
Example 3:

Input: n = 2, k = 2
Output: 1
Explanation:
row 1: 0
row 2: 01


Constraints:

1 <= n <= 30
1 <= k <= 2n - 1


Recursion:
Firstly, after generating a few rows using the steps given in the problem description, we can observe two patterns:

1. The previous row is used as the prefix of the next row.
2. If we divide any row into two equal halves then the symbol at each position will be opposite of each other in both halves (i.e. if we have a 0 in the left half at index i, then the right half will have a 1 at index i, and vice versa).


 */