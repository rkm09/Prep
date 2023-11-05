package leet.medium;

import java.util.LinkedList;
import java.util.Queue;

public class GetArrWinner {
    public static void main(String[] args) {
        int[] arr = {2,1,3,5,4,6,7};
        int k = 2;
        int[] arr1 = {3,2,1}; int k1 = 10;
        int res = getWinner(arr, k);
        System.out.println(res);
    }

//    without queue; time: O(n), space: O(1)
    public static int getWinner(int[] arr, int k) {
        int maxElement = arr[0];
        for(int elem : arr) {
            maxElement = Math.max(elem, maxElement);
        }
        int j = 1; int curr = arr[0];
        int winstreak = 0;
        while((winstreak < k) && (curr != maxElement)) {
            if(curr < arr[j]) {
                curr = arr[j++];
                winstreak = 1;
            } else {
                winstreak++; j++;
            }
        }
        return curr;
    }

//    with queue; time: O(n), space: O(n)
    public static int getWinner1(int[] arr, int k) {
        int maxElement = arr[0], n = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i < n ; i++) {
            maxElement = Math.max(maxElement, arr[i]);
            queue.offer(arr[i]);
        }
        int winStreak = 0;
        int curr = arr[0];
        while(!queue.isEmpty()) {
            int elem = queue.poll();
            if(curr > elem) {
                queue.offer(elem);
                winStreak++;
            } else {
                queue.offer(curr);
                curr = elem;
                winStreak = 1;
            }
            if((winStreak == k) || (curr == maxElement)){
                return curr;
            }
        }
        return -1;
    }

//    initial
    public static int getWinnerN(int[] arr, int k) {
        int n = arr.length;
        int winner = arr[0];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i < n ; i++) {
            queue.add(arr[i]);
        }
        int count = 0;
        int j = 0;
        while((j++ < n) && (count < k)) {
            int elem = queue.remove();
            if(winner < elem) {
                queue.add(winner);
                winner = elem;
                count = 1;
            } else {
                queue.add(elem);
                count++;
            }
//            System.out.println("winner: "+winner+", count: "+count+", elem: "+elem);
        }
        return winner;
    }
}

/*
Given an integer array arr of distinct integers and an integer k.

A game will be played between the first two elements of the array (i.e. arr[0] and arr[1]). In each round of the game, we compare arr[0] with arr[1], the larger integer wins and remains at position 0, and the smaller integer moves to the end of the array. The game ends when an integer wins k consecutive rounds.

Return the integer which will win the game.

It is guaranteed that there will be a winner of the game.



Example 1:

Input: arr = [2,1,3,5,4,6,7], k = 2
Output: 5
Explanation: Let's see the rounds of the game:
Round |       arr       | winner | win_count
  1   | [2,1,3,5,4,6,7] | 2      | 1
  2   | [2,3,5,4,6,7,1] | 3      | 1
  3   | [3,5,4,6,7,1,2] | 5      | 1
  4   | [5,4,6,7,1,2,3] | 5      | 2
So we can see that 4 rounds will be played and 5 is the winner because it wins 2 consecutive games.
Example 2:

Input: arr = [3,2,1], k = 10
Output: 3
Explanation: 3 will win the first 10 rounds consecutively.
 */