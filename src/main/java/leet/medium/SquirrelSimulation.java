package leet.medium;

public class SquirrelSimulation {
    public static void main(String[] args) {
        int height = 5, width = 7;
        int[] tree = {2,2};
        int[] squirrel = {4,4};
        int[][] nuts = {{3,0},{2,5}};
        int res = minDistance(height, width, tree, squirrel, nuts);
        System.out.println(res);
    }
//    time: O(n), space: O(1)
    public static int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int totalDist = 0;
        int savings = Integer.MIN_VALUE;
        for(int[] nut : nuts) {
            totalDist += 2 * (distance(tree, nut));
            savings = Math.max(savings, distance(tree, nut) - distance(squirrel, nut));
        }
        totalDist = totalDist - savings;
        return totalDist;
    }
    public static int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}

/*
You are given two integers height and width representing a garden of size height x width. You are also given:

an array tree where tree = [treer, treec] is the position of the tree in the garden,
an array squirrel where squirrel = [squirrelr, squirrelc] is the position of the squirrel in the garden,
and an array nuts where nuts[i] = [nutir, nutic] is the position of the ith nut in the garden.
The squirrel can only take at most one nut at one time and can move in four directions: up, down, left, and right, to the adjacent cell.

Return the minimal distance for the squirrel to collect all the nuts and put them under the tree one by one.

The distance is the number of moves.
Input: height = 5, width = 7, tree = [2,2], squirrel = [4,4], nuts = [[3,0], [2,5]]
Output: 12
Explanation: The squirrel should go to the nut at [2, 5] first to achieve a minimal distance.
Input: height = 1, width = 3, tree = [0,1], squirrel = [0,0], nuts = [[0,2]]
Output: 3


Constraints:

1 <= height, width <= 100
tree.length == 2
squirrel.length == 2
1 <= nuts.length <= 5000
nuts[i].length == 2
0 <= treer, squirrelr, nutir <= height
0 <= treec, squirrelc, nutic <= width
 */