package leet.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FullBloomFlowers {
    public static void main(String[] args) {
        int[][] flowers = {{1,6},{3,7},{9,12},{4,13}};
        int[] people = {2,3,7,11};
        int[] res = fullBloomFlowers(flowers, people);
        System.out.println(Arrays.toString(res));
    }

//    Binary Search
    public static int[] fullBloomFlowers(int[][] flowers, int[] people) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();

        for(int[] flower : flowers) {
            starts.add(flower[0]);
            ends.add(flower[1] + 1);
        }

        Collections.sort(starts);
        Collections.sort(ends);

        int[] ans = new int[people.length];

        for(int i = 0 ; i < people.length ; i++) {
            int a = binarySearch(starts, people[i]);
            int b = binarySearch(ends, people[i]);
            int alive = a - b;
            ans[i] = alive;
        }

        return ans;
    }

    public static int binarySearch(List<Integer> li, int target) {
        int left = 0;
        int right = li.size();
        while(left < right) {
            int mid = (left + right) / 2;
            if(target < li.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
//    Useless brute force TLE :|
    public static int[] fullBloomFlowers1(int[][] flowers, int[] people) {
        int[] res = new int[people.length];
        for(int i = 0 ; i < people.length ; i++) {
            for(int j = 0 ; j < flowers.length ; j++) {
                if(people[i] >= flowers[j][0] && people[i] <= flowers[j][1]) res[i] += 1;
            }
        }
        return res;
    }
}

/*
You are given a 0-indexed 2D integer array flowers, where flowers[i] = [starti, endi] means the ith flower will be in full bloom from starti to endi (inclusive). You are also given a 0-indexed integer array people of size n, where people[i] is the time that the ith person will arrive to see the flowers.
Return an integer array answer of size n, where answer[i] is the number of flowers that are in full bloom when the ith person arrives.
Input: flowers = [[1,6],[3,7],[9,12],[4,13]], poeple = [2,3,7,11]
Output: [1,2,2,2]
Explanation: The figure above shows the times when the flowers are in full bloom and when the people arrive.
For each person, we return the number of flowers in full bloom during their arrival.
Constraints:
1 <= flowers.length <= 5 * 10^4
flowers[i].length == 2
1 <= starti <= endi <= 10^9
1 <= people.length <= 5 * 10^4
1 <= people[i] <= 10^9

Binary Search:
Complexity Analysis:

Given nnn as the length of flowers and mmm as the length of people,
Time complexity: O((n+m)⋅logn)
We first create two arrays of length nnn, starts and ends, then sort them. This costs O(n⋅logn).
Next, we iterate over people and perform two binary searches at each iteration. This costs O(m⋅logn).
Thus, our time complexity is O((n+m)⋅logn).

Space complexity: O(n)
starts and ends both have a size of n.

Algorithm

Create two arrays starts and ends.
Iterate over each flower = [start, end] in flowers:
Add start to starts.
Add end + 1 to ends.
Sort both starts and ends.
Initialize the answer array ans and iterate over each person in people:
Perform a binary search on starts for the rightmost insertion index of person to find i.
Perform a binary search on ends for the rightmost insertion index of person to find j.
Add i - j to ans.
Return ans.

For each flower = [start, end], we indicated that at time start, we see one more flower, and at time end + 1, we see one less flower. We identified when a flower started blooming and when it finished blooming.
the number of flowers we see is the number of flowers that have already started blooming minus the amount of flowers have finished blooming.
Note that a flower = [start, end] stops blooming at end + 1, not end. There are two ways we can handle this. We can either binary search on end for the leftmost insertion index (since we want to include all flowers with end equal to the current time), or we can assemble ends using end + 1 for each flower.
*/