package leet.hard;

import java.util.*;

public class ParallelCoursesIII {
    public static void main(String[] args) {
        int n = 3;
        int[][] relations = {{1,3},{2,3}};
        int[] time = {3,2,5};
        int res = minimumTime(n, relations, time);
        System.out.println(res);
    }
    public static int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0 ; i < n ; i++) {
            graph.put(i, new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for(int[] edge : relations) {
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            graph.get(x).add(y);
            inDegree[y]++;
        }

        int[] maxTime = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        for(int node = 0 ; node < n ; node++) {
            if(inDegree[node] == 0) {
                queue.add(node);
                maxTime[node] = time[node];
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.remove();
            for(int neighbour : graph.get(node)) {
                maxTime[neighbour] = Math.max(maxTime[neighbour], maxTime[node]+time[neighbour]);
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0)
                    queue.add(neighbour);
            }
        }

        int ans = 0;
        for(int i = 0 ; i < n ; i++) {
            ans = Math.max(ans, maxTime[i]);
        }

        return ans;
    }
}

/*
You are given an integer n, which indicates that there are n courses labeled from 1 to n. You are also given a 2D integer array relations where relations[j] = [prevCoursej, nextCoursej] denotes that course prevCoursej has to be completed before course nextCoursej (prerequisite relationship). Furthermore, you are given a 0-indexed integer array time where time[i] denotes how many months it takes to complete the (i+1)th course.

You must find the minimum number of months needed to complete all the courses following these rules:

You may start taking a course at any time if the prerequisites are met.
Any number of courses can be taken at the same time.
Return the minimum number of months needed to complete all the courses.

Note: The test cases are generated such that it is possible to complete every course (i.e., the graph is a directed acyclic graph).

Input: n = 3, relations = [[1,3],[2,3]], time = [3,2,5]
Output: 8
Explanation: The figure above represents the given graph and the time required to complete each course.
We start course 1 and course 2 simultaneously at month 0.
Course 1 takes 3 months and course 2 takes 2 months to complete respectively.
Thus, the earliest time we can start course 3 is at month 3, and the total time required is 3 + 5 = 8 months.

Input: n = 5, relations = [[1,5],[2,5],[3,5],[3,4],[4,5]], time = [1,2,3,4,5]
Output: 12
Explanation: The figure above represents the given graph and the time required to complete each course.
You can start courses 1, 2, and 3 at month 0.
You can complete them after 1, 2, and 3 months respectively.
Course 4 can be taken only after course 3 is completed, i.e., after 3 months. It is completed after 3 + 4 = 7 months.
Course 5 can be taken only after courses 1, 2, 3, and 4 have been completed, i.e., after max(1,2,3,7) = 7 months.
Thus, the minimum time needed to complete all the courses is 7 + 5 = 12 months.

Constraints:

1 <= n <= 5 * 104
0 <= relations.length <= min(n * (n - 1) / 2, 5 * 104)
relations[j].length == 2
1 <= prevCoursej, nextCoursej <= n
prevCoursej != nextCoursej
All the pairs [prevCoursej, nextCoursej] are unique.
time.length == n
1 <= time[i] <= 104

-------------------------------------------------------
The given graph is a directed acyclic graph.

Given e as the length of relations,

Time complexity: O(n+e)

It costs O(e) to build graph and O(n) to initialize maxTime, queue, and inDegree.

During Kahn's algorithm, each node is pushed and popped to queue once, costing O(n). We have a for loop inside the while loop, but this for loop is iterating over edges. Because we only visit each node once, each edge in the input can only be iterated over once as well. This means all for loop iterations across the algorithm will cost O(e).

Space complexity: O(n+e)

graph takes O(n+e) space, the queue can take up to O(n) space, maxTime and inDegree both take O(n) space.
 */