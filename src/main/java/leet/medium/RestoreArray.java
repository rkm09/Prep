package leet.medium;

import java.util.*;


public class RestoreArray {
    static Map<Integer, List<Integer>>  graph = new HashMap<>();
    public static void main(String[] args) {
        int[][] adjacentPairs = {{2,1},{3,4},{3,2}};
        int[] res = restoreArray(adjacentPairs);
        System.out.println(Arrays.toString(res));
    }

//    Iterative dfs; time: O(n), space: O(n)
    public static int[] restoreArray(int[][] adjacentPairs) {
        for(int[] edges : adjacentPairs) {
            int x = edges[0];
            int y = edges[1];
            if(!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
            }
            if(!graph.containsKey(y)) {
                graph.put(y, new ArrayList<>());
            }
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        int root = 0;
        for(int num : graph.keySet()) {
            if(graph.get(num).size() == 1) {
                root = num;
                break;
            }
        }
        int[] ans = new int[graph.size()];
        int curr = root ;
        ans[0] = root;
        int i = 1;
        int prev = Integer.MAX_VALUE;
        while(i < graph.size()) {
            for(int neighbour : graph.get(curr)) {
                if(neighbour != prev) {
                    ans[i] = neighbour;
                    i++;
                    prev = curr;
                    curr = neighbour;
                    break;
                }
            }
        }
        return ans;
    }

//     DFS; time: O(n), space: O(n)
    public static int[] restoreArray1(int[][] adjacentPairs) {
        for(int[] edges : adjacentPairs) {
            int x = edges[0];
            int y = edges[1];
            if(!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
            }
            if(!graph.containsKey(y)) {
                graph.put(y, new ArrayList<>());
            }
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        int root = 0;
        for(int num : graph.keySet()) {
            if(graph.get(num).size() == 1) {
                root = num;
                break;
            }
        }
        int[] ans = new int[graph.size()];
        int prev = Integer.MAX_VALUE;
        dfs(root, prev, ans, 0);
        return ans;
    }
    public static void dfs(int node, int prev, int[] ans, int i) {
        ans[i] = node;
        for(int neighbour : graph.get(node)) {
            if(neighbour != prev) {
                dfs(neighbour, node, ans, i+1);
            }
        }
    }
}

/*
There is an integer array nums that consists of n unique elements, but you have forgotten it. However, you do remember every pair of adjacent elements in nums.

You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi] indicates that the elements ui and vi are adjacent in nums.

It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs, either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.

Return the original array nums. If there are multiple solutions, return any of them.



Example 1:

Input: adjacentPairs = [[2,1],[3,4],[3,2]]
Output: [1,2,3,4]
Explanation: This array has all its adjacent pairs in adjacentPairs.
Notice that adjacentPairs[i] may not be in left-to-right order.
Example 2:

Input: adjacentPairs = [[4,-2],[1,4],[-3,1]]
Output: [-2,4,1,-3]
Explanation: There can be negative numbers.
Another solution is [-3,1,4,-2], which would also be accepted.
Example 3:

Input: adjacentPairs = [[100000,-100000]]
Output: [100000,-100000]


Constraints:

nums.length == n
adjacentPairs.length == n - 1
adjacentPairs[i].length == 2
2 <= n <= 105
-105 <= nums[i], ui, vi <= 105
There exists some nums that has adjacentPairs as its pairs.
 */