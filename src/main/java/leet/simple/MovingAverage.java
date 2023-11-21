package leet.simple;

import java.util.*;

// circular queue; time: O(1), space: O(n)
public class MovingAverage {
    int size, head, windowSum, count;
    int[] cqueue;
    public MovingAverage(int size) {
        this.size = size;
        head = 0; windowSum = 0; count = 0;
        cqueue = new int[size];
    }
    public double next(int val) {
        ++count;
        int tail = (head + 1) % size;
        windowSum += val - cqueue[tail];
        head = (head + 1) % size;
        cqueue[head] = val;
        return windowSum * 1.0 / Math.min(size, count);
    }
}

// Dequeue
class MovingAverage1 {
    int size, sum, count;
    Queue<Integer> deque;
    public MovingAverage1(int size) {
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

// Queue
class MovingAverage2 {
    int size;
    List<Integer> queue;
    public MovingAverage2(int size) {
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
        MovingAverage movingAverage = new MovingAverage(3);
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


The major advantage of circular queue is that by adding a new element to a full circular queue, it automatically discards the oldest element. Unlike deque, we do not need to explicitly remove the oldest element.
Another advantage of circular queue is that a single index suffices to keep track of both ends of the queue, unlike deque where we have to keep a pointer for each end.
tail=(head+1)modsize

 */