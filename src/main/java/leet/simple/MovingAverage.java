package leet.simple;

import java.util.*;

public class MovingAverage {
    int size, sum, count;
    Queue<Integer> deque;
    public MovingAverage(int size) {
        this.size = size;
        sum = 0; count = 0;
        deque = new ArrayDeque<>();
    }
//  time: O(1), space: O(n)
    public double next(int val) {
        count++;
        deque.add(val);
        int out = (size < count) ? deque.poll() : 0;
        sum += val - out;
        return sum * 1.0 / Math.min(size, count);
    }
}

class MovingAverage1 {
    int size;
    List<Integer> queue;
    public MovingAverage1(int size) {
        this.size = size;
        queue = new ArrayList<>();
    }
//    slowest; time: O(n), space: O(n)
    public double next(int val) {
        int sum = 0;
        queue.add(val);
        for(int i = Math.max(queue.size() - size,0); i < queue.size() ; i++) {
            sum += queue.get(i);
        }
        return sum * 1.0 / Math.min(size, queue.size());
    }
}

class TestMA {
    public static void main(String[] args) {
        MovingAverage1 movingAverage = new MovingAverage1(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }
}

/*
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Implement the MovingAverage class:

MovingAverage(int size) Initializes the object with the size of the window size.
double next(int val) Returns the moving average of the last size values of the stream.


Example 1:

Input
["MovingAverage", "next", "next", "next", "next"]
[[3], [1], [10], [3], [5]]
Output
[null, 1.0, 5.5, 4.66667, 6.0]

Explanation
MovingAverage movingAverage = new MovingAverage(3);
movingAverage.next(1); // return 1.0 = 1 / 1
movingAverage.next(10); // return 5.5 = (1 + 10) / 2
movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3


Constraints:

1 <= size <= 1000
-105 <= val <= 105
At most 104 calls will be made to next.
 */