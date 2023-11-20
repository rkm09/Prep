package leet.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GarbageCollector {
    public static void main(String[] args) {
        String[] garbage = {"G","P","GP","GG"};
        int[] travel = {2,4,3};
        System.out.println(garbageCollection(garbage, travel));
    }
    public static int garbageCollection(String[] garbage, int[] travel) {
        int count = 0;
        int n = garbage.length;
        int[] weight = new int[n];
        Map<Character, Integer> hcount = new HashMap<>();
        for(int i = 0 ; i < travel.length ; i++) {
            weight[i+1] = travel[i] + weight[i];
        }
        for(int i = n-1 ; i >= 0 ; i--) {
            char[] carr = garbage[i].toCharArray();
            int j = 0;
            while(j < carr.length) {
                hcount.put(carr[j], hcount.getOrDefault(carr[j], 0) + 1);
                if(hcount.get(carr[j]) == 1) {
                    hcount.put(carr[j], hcount.get(carr[j]) + weight[i]);
                }
                j++;
            }
        }
        for(Character key  : hcount.keySet()) {
            count += hcount.get(key);
        }
        return count;
    }
}

/*
You are given a 0-indexed array of strings garbage where garbage[i] represents the assortment of garbage at the ith house. garbage[i] consists only of the characters 'M', 'P' and 'G' representing one unit of metal, paper and glass garbage respectively. Picking up one unit of any type of garbage takes 1 minute.
You are also given a 0-indexed integer array travel where travel[i] is the number of minutes needed to go from house i to house i + 1.
There are three garbage trucks in the city, each responsible for picking up one type of garbage. Each garbage truck starts at house 0 and must visit each house in order; however, they do not need to visit every house.
Only one garbage truck may be used at any given moment. While one truck is driving or picking up garbage, the other two trucks cannot do anything.
Return the minimum number of minutes needed to pick up all the garbage.
Example 1:
Input: garbage = ["G","P","GP","GG"], travel = [2,4,3]
Output: 21
Explanation:
The paper garbage truck:
Altogether, it takes 8 minutes to pick up all the paper garbage.
The glass garbage truck:
Altogether, it takes 13 minutes to pick up all the glass garbage.
Since there is no metal garbage, we do not need to consider the metal garbage truck.
Therefore, it takes a total of 8 + 13 = 21 minutes to collect all the garbage.
Example 2:
Input: garbage = ["MMM","PGM","GP"], travel = [3,10]
Output: 37


Constraints:

2 <= garbage.length <= 105
garbage[i] consists of only the letters 'M', 'P', and 'G'.
1 <= garbage[i].length <= 10
travel.length == garbage.length - 1
1 <= travel[i] <= 100
 */