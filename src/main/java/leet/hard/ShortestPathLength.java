package leet.hard;

public class ShortestPathLength {
    public static void main(String[] args) {
        int[][] graph = {{1,2,3},{0},{0},{0}};
        int length = shortestPathLength(graph);
        System.out.println(length);
    }
    public static int shortestPathLength(int[][] graph) {
        return -1;
    }

}

/*
You have an undirected, connected graph of n nodes labeled from 0 to n - 1. You are given an array graph where graph[i] is a list of all the nodes connected with node i by an edge.
Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.
Input: graph = [[1,2,3],[0],[0],[0]]
Output: 4
Explanation: One possible path is [1,0,2,0,3]
 */