package leet.hard;

import java.util.Arrays;

//floyd-warshall
public class Graph {
    int[][] adjacencyMatrix;
    public Graph(int n, int[][] edges) {
        adjacencyMatrix = new int[n][n];
        Arrays.stream(adjacencyMatrix).forEach(row -> Arrays.fill(row, (int)1e9));
        for(int[] edge : edges) {
            adjacencyMatrix[edge[0]][edge[1]] = edge[2];
        }
        for(int i = 0 ; i < n ; i++) {
            adjacencyMatrix[i][i] = 0;
        }
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                for(int k = 0 ; k < n ; k++) {
                    adjacencyMatrix[j][k] = Math.min(adjacencyMatrix[j][k],
                            adjacencyMatrix[j][i] + adjacencyMatrix[i][k]);
                }
            }
        }
    }
    public void addEdge(int[] edge) {
        int n = adjacencyMatrix.length;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                adjacencyMatrix[i][j] = Math.min(adjacencyMatrix[i][j],
                        adjacencyMatrix[i][edge[0]] + adjacencyMatrix[edge[1]][j] + edge[2]);
            }
        }
    }
    public int shortestPath(int node1, int node2) {
        if(adjacencyMatrix[node1][node2] == (int)1e9) {
            return -1;
        }
        return adjacencyMatrix[node1][node2];
    }
}

class TestGraph{
    public static void main(String[] args) {
        int[][] edges = {{0,2,5},{0,1,2},{1,2,1},{3,0,3}};
        int n = 4;
        Graph graph = new Graph(n, edges);
        int shortestPath = graph.shortestPath(3,2);
        System.out.println("Shortest path between 3 & 2: "+shortestPath);
        int shortestPath2 = graph.shortestPath(0,3);
        System.out.println("Shortest path between 0 & 3: "+shortestPath2);
        int[] edge = {1,3,4};
        System.out.println("Add edge 1,3 and dist 4");
        graph.addEdge(edge);
        int shortestPath3 = graph.shortestPath(0,3);
        System.out.println("Shortest path between 0 & 3: "+shortestPath3);
    }
}

/*
There is a directed weighted graph that consists of n nodes numbered from 0 to n - 1. The edges of the graph are initially represented by the given array edges where edges[i] = [fromi, toi, edgeCosti] meaning that there is an edge from fromi to toi with the cost edgeCosti.

Implement the Graph class:

Graph(int n, int[][] edges) initializes the object with n nodes and the given edges.
addEdge(int[] edge) adds an edge to the list of edges where edge = [from, to, edgeCost]. It is guaranteed that there is no edge between the two nodes before adding this one.
int shortestPath(int node1, int node2) returns the minimum cost of a path from node1 to node2. If no path exists, return -1. The cost of a path is the sum of the costs of the edges in the path.
Input
["Graph", "shortestPath", "shortestPath", "addEdge", "shortestPath"]
[[4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]], [3, 2], [0, 3], [[1, 3, 4]], [0, 3]]
Output
[null, 6, -1, null, 6]

Explanation
Graph g = new Graph(4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]);
g.shortestPath(3, 2); // return 6. The shortest path from 3 to 2 in the first diagram above is 3 -> 0 -> 1 -> 2 with a total cost of 3 + 2 + 1 = 6.
g.shortestPath(0, 3); // return -1. There is no path from 0 to 3.
g.addEdge([1, 3, 4]); // We add an edge from node 1 to node 3, and we get the second diagram above.
g.shortestPath(0, 3); // return 6. The shortest path from 0 to 3 now is 0 -> 1 -> 3 with a total cost of 2 + 4 = 6.


Constraints:

1 <= n <= 100
0 <= edges.length <= n * (n - 1)
edges[i].length == edge.length == 3
0 <= fromi, toi, from, to, node1, node2 <= n - 1
1 <= edgeCosti, edgeCost <= 106
There are no repeated edges and no self-loops in the graph at any point.
At most 100 calls will be made for addEdge.
At most 100 calls will be made for shortestPath.


Complexity:
Floyd-warshall:
Complexity Analysis
Let E be number of edges in the graph when the call to any method is made.
Let V be the number of vertices in the graph when the call to any method is made.
Let N be the maximum number of calls made to addEdge.
Let M be the maximum number of calls made to shortestPath.
Time complexity: O(M + N⋅V^2 + V^3)

initialization: O(V^3).
addEdge:O(N⋅V^2)
When this operation is performed N times, it results in a time complexity of O(N⋅V^2)
shortestPath: O(M). Finding the shortestPath doesn't require any additional computation. Hence, it incurs a constant time complexity of O(1). When this operation is performed MMM times, it results in a linear time complexity of O(M).
Space complexity:O(V^2)
initialization: O(V^2)
We initialize a 2-D adjacency matrix that stores the minimum cost between all vertices.
addEdge: O(1). We will not need any extra space to add an edge.
shortestPath: O(1). We will not need any extra space to return the cost of the shortest path.
 */