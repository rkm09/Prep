package leet.medium;

import java.util.*;

public class AssignBikes {
    public static void main(String[] args) {
        int[][] workers = {{0,0},{2,1}};
        int[][] bikes = {{1,2},{3,3}};
        AssignBikes ab = new AssignBikes();
        int[] res = ab.assignBikes(workers, bikes);
        System.out.println(Arrays.toString(res));
    }
    class WorkerBikePair {
        int workerIndex;
        int bikeIndex;
        int distance;
        WorkerBikePair(int workerIndex, int bikeIndex, int distance) {
            this.workerIndex = workerIndex;
            this.bikeIndex = bikeIndex;
            this.distance = distance;
        }
    }
    Comparator<WorkerBikePair> workerBikePairComparator = new Comparator<WorkerBikePair>() {
      @Override
      public int compare(WorkerBikePair a, WorkerBikePair b) {
          if(a.distance != b.distance) {
              return a.distance - b.distance;
          } else if(a.workerIndex != b.workerIndex) {
              return a.workerIndex - b.workerIndex;
          } else {
              return a.bikeIndex - b.bikeIndex;
          }
      }
    };

    public int findDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

//    Sorting
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        List<WorkerBikePair> allTriplets = new ArrayList<>();
        for(int worker = 0 ; worker < workers.length ; worker++) {
            for(int bike = 0 ; bike < bikes.length ; bike++) {
                int distance = findDistance(workers[worker], bikes[bike]);
                WorkerBikePair workerBikePair = new WorkerBikePair(worker, bike, distance);
                allTriplets.add(workerBikePair);
            }
        }
        Collections.sort(allTriplets, workerBikePairComparator);

        int[] workerStatus = new int[workers.length];
        boolean[] bikeStatus = new boolean[bikes.length];
        int pairCount = 0;
        Arrays.fill(workerStatus, -1);

        for(WorkerBikePair triplet : allTriplets) {
            int worker = triplet.workerIndex;
            int bike = triplet.bikeIndex;
            if(workerStatus[worker] == -1 && !bikeStatus[bike]) {
                workerStatus[worker] = bike;
                bikeStatus[bike] = true;
                pairCount++;
            }
            if(pairCount == workers.length) {
                return workerStatus;
            }
        }
        return workerStatus;
    }

}

/*
On a campus represented on the X-Y plane, there are n workers and m bikes, with n <= m.

You are given an array workers of length n where workers[i] = [xi, yi] is the position of the ith worker. You are also given an array bikes of length m where bikes[j] = [xj, yj] is the position of the jth bike. All the given positions are unique.

Assign a bike to each worker. Among the available bikes and workers, we choose the (workeri, bikej) pair with the shortest Manhattan distance between each other and assign the bike to that worker.

If there are multiple (workeri, bikej) pairs with the same shortest Manhattan distance, we choose the pair with the smallest worker index. If there are multiple ways to do that, we choose the pair with the smallest bike index. Repeat this process until there are no available workers.

Return an array answer of length n, where answer[i] is the index (0-indexed) of the bike that the ith worker is assigned to.

The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.

Input: workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
Output: [1,0]
Explanation: Worker 1 grabs Bike 0 as they are closest (without ties), and Worker 0 is assigned Bike 1. So the output is [1, 0].
Input: workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
Output: [0,2,1]
Explanation: Worker 0 grabs Bike 0 at first. Worker 1 and Worker 2 share the same distance to Bike 2, thus Worker 1 is assigned to Bike 2, and Worker 2 will take Bike 1. So the output is [0,2,1].


Constraints:

n == workers.length
m == bikes.length
1 <= n <= m <= 1000
workers[i].length == bikes[j].length == 2
0 <= xi, yi < 1000
0 <= xj, yj < 1000
All worker and bike locations are unique.

Approach 1: Sorting
Complexity Analysis

Here, N is the number of workers, and M is the number of bikes.

Time complexity: O(NMlog(NM))

There will be a total of NM (worker, bike) pairs. Sorting a list of NMelements will cost O(NMlog(NM)) time. In the worst case, we have to iterate over all the pairs to assign each worker a bike. Thus, iterating over these pairs costs O(NM) time. Since the time complexity for sorting is the dominant term, the time complexity is O(NMlog(NM)).

Space complexity: O(NM)

WorkerBikePair or the tuple has three variables, hence taking O(1) space. Storing NM WorkerBikePairs or tuples in allTriplets will cost O(NM) space. To track the availability of the bikes bikeStatus takes O(M) space. Storing bikes index corresponding to worker index in workerStatus takes O(N) space.

The space complexity of the sorting algorithm depends on the implementation of each programming language. For instance, in Java, the Arrays.sort() for primitives is implemented as a variant of quicksort algorithm whose space complexity is O(logNM). In C++ sort() function provided by STL is a hybrid of Quick Sort, Heap Sort, and Insertion Sort and has a worst-case space complexity of O(logNM). In Python sort() function uses TimSort which has a worst-case space complexity of O(NM). Thus, the use of the inbuilt sort() function might add up to O(NM) to space complexity.

The total space required is (NM+N+M+NM) hence, the complexity is equal to O(NM).


 */