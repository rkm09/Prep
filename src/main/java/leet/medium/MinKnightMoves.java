package leet.medium;

import java.util.*;

public class MinKnightMoves {
    public static void main(String[] args) {
        int x = 2, y = 1;
        int out = minKnightMoves(x, y);
        System.out.println(out);
    }

//    BFS:: bidirectional
    public static int minKnightMoves(int x, int y) {
        // the offsets in the eight directions
        int[][] offsets = {{1, 2}, {2, 1}, {1, -2}, {-2, 1},{-1, 2},{2, -1},{-1, -2}, {-2, -1}};
        // data structures needed to move from the origin point
        Deque<int[]> originQueue = new LinkedList<>();
        originQueue.addLast(new int[]{0, 0, 0});
        Map<String, Integer> originDistance = new HashMap<>();
        originDistance.put("0,0", 0);
        // data structures needed to move from the target point
        Deque<int[]> targetQueue = new LinkedList<>();
        targetQueue.addLast(new int[]{x, y, 0});
        Map<String, Integer> targetDistance = new HashMap<>();
        targetDistance.put(x+","+y, 0);

        while(true) {
            // check if we reach the circle of target
            int[] origin = originQueue.removeFirst();
            String originXY = origin[0] + "," + origin[1];
            if(targetDistance.containsKey(originXY)) {
                return origin[2] + targetDistance.get(originXY);
            }
            // check if we reach the circle of origin
            int[] target = targetQueue.removeFirst();
            String targetXY = target[0] + "," + target[1];
            if(originDistance.containsKey(targetXY)) {
                return target[2] + originDistance.get(targetXY);
            }

            for(int[] offset : offsets) {
                // expand the circle of origin
                int[] nextOrigin = new int[]{origin[0] + offset[0], origin[1] + offset[1]};
                String nextOriginXY = nextOrigin[0] + "," + nextOrigin[1];
                if(!originDistance.containsKey(nextOriginXY)) {
                    originQueue.addLast(new int[]{nextOrigin[0], nextOrigin[1], origin[2] + 1});
                    originDistance.put(nextOriginXY, origin[2] + 1);
                }
                // expand the circle of target
                int[] nextTarget = new int[]{target[0] + offset[0], target[1] + offset[1]};
                String nextTargetXY = nextTarget[0] + "," + nextTarget[1];
                if(!targetDistance.containsKey(nextTargetXY)) {
                    targetQueue.addLast(new int[]{nextTarget[0], nextTarget[1], target[2] + 1});
                    targetDistance.put(nextTargetXY, target[2] + 1);
                }
            }
        }
    }
}

/*
In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].

A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
Return the minimum number of steps needed to move the knight to the square [x, y]. It is guaranteed the answer exists.

Example 1:

Input: x = 2, y = 1
Output: 1
Explanation: [0, 0] → [2, 1]
Example 2:

Input: x = 5, y = 5
Output: 4
Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]


Constraints:

-300 <= x, y <= 300
0 <= |x| + |y| <= 300


Based on the above idea of BFS, one optimization that we can apply is to perform bidirectional exploration instead of unidirectional exploration.
Intuitively, as we can see from the above graph, the area of the orange circles that we explore with bidirectional BFS is much smaller than the area of the red circle that we would explore with unidirectional BFS (twice as small, to be exact).

Complexity Analysis

Although the bidirectional BFS cuts the exploration scope in half, compared to the unidirectional BFS, the overall time and space complexities remain the same.
We will break it down in detail in this section.

Firstly, given the target's coordinate, (x,y)(x, y)(x,y), then the area that is covered by the two exploratory circles of the bidirectional BFS will be max(∣x∣,∣y∣)^2


Time Complexity: O((max(∣x∣,∣y∣))^2

Reducing the scope of exploration by half does speed up the algorithm. However, it does not change the time complexity of the algorithm which remains O((max(∣x∣,∣y∣))^2

Space Complexity: O((max(∣x∣,∣y∣))^2


In exchange for reducing the search scope, we double the usage of data structures compared to the unidirectional BFS.
Similarly to the time complexity, multiplying the required space by two does not change the overall space complexity of the algorithm which remains O((max(∣x∣,∣y∣))^2

 */