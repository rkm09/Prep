package top150.medium;

import java.util.ArrayList;
import java.util.List;

public class GasStation134 {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int[] gas1 = {1,2,3,4,5,5,70};
        int[] cost1 = {2,3,4,3,9,6,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

//    One pass; time: O(n), space: O(1)
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGain = 0;
        int currGain = 0, startIndex = 0;
        for(int i = 0 ; i < gas.length ; i++) {
            totalGain += gas[i] - cost[i];
            currGain += gas[i] - cost[i];
            if(currGain < 0) {
                startIndex = i + 1;
                currGain = 0;
            }
        }
        return totalGain >= 0 ? startIndex : -1;
    }

//    [def] TLE !! :|
    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        int n = gas.length, left;
        List<Integer> candidates = new ArrayList<>();
        int[] diff = new int[n];
        int sumDiff = 0;
        for(int i = 0 ; i < n ; i++) {
            diff[i] = gas[i] - cost[i];
            sumDiff += diff[i];
            if(diff[i] >= 0) candidates.add(i);
        }
        if(sumDiff < 0) return -1;
        for(int candidate : candidates) {
            left = 0;
            int index = candidate;
            int count = 0;
            while(count++ < n) {
                left += diff[index];
                index = (index + 1 == n) ? 0 : index + 1;
                if(left < 0) break;
            }
            if(left >= 0) return candidate;
        }
        return -1;
    }
}

/*
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique
Example 1:
Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
Example 2:
Input: gas = [2,3,4], cost = [3,4,3]
Output: -1
Explanation:
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
Therefore, you can't travel around the circuit once no matter where you start.
Constraints:
n == gas.length == cost.length
1 <= n <= 105
0 <= gas[i], cost[i] <= 104
 */