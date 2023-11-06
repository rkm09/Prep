package leet.medium;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class SeatReserve {
    public static void main(String[] args) {
        SeatManager seatManager = new SeatManager(5);
        int res = seatManager.reserve();
        int res1 = seatManager.reserve();
        seatManager.unreserve(1);

        System.out.println(res1);
    }
}

// Using Min heap; time: O(mlogn), space: O(n)
class SeatManager1 {
    int marker;
    PriorityQueue<Integer> availableSeats;
    public SeatManager1(int n) {
        marker = 1;
        availableSeats = new PriorityQueue<>();
    }

    public int reserve() {
        if(!availableSeats.isEmpty()) {
            int seatNumber = availableSeats.poll();
            return seatNumber;
        }
        int seatNumber = marker;
        marker++;
        return seatNumber;
    }

    public void unreserve(int seatNumber) {
        availableSeats.offer(seatNumber);
    }
}

// Sorted set (internally uses height balances BST); time: O(mlogn), space: O(n)
class SeatManager {
    int marker;
    TreeSet<Integer> availableSeats;
    public SeatManager(int n) {
        marker = 1;
        availableSeats = new TreeSet<>();
    }

    public int reserve() {
        if(!availableSeats.isEmpty()) {
           int seatNumber = availableSeats.first();
           availableSeats.remove(seatNumber);
           return seatNumber;
        }
        int seatNumber = marker;
        marker++;
        return seatNumber;
    }

    public void unreserve(int seatNumber) {
        availableSeats.add(seatNumber);
    }
}
/*
Design a system that manages the reservation state of n seats that are numbered from 1 to n.

Implement the SeatManager class:

SeatManager(int n) Initializes a SeatManager object that will manage n seats numbered from 1 to n. All seats are initially available.
int reserve() Fetches the smallest-numbered unreserved seat, reserves it, and returns its number.
void unreserve(int seatNumber) Unreserves the seat with the given seatNumber.


Example 1:

Input
["SeatManager", "reserve", "reserve", "unreserve", "reserve", "reserve", "reserve", "reserve", "unreserve"]
[[5], [], [], [2], [], [], [], [], [5]]
Output
[null, 1, 2, null, 2, 3, 4, 5, null]

Explanation
SeatManager seatManager = new SeatManager(5); // Initializes a SeatManager with 5 seats.
seatManager.reserve();    // All seats are available, so return the lowest numbered seat, which is 1.
seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
seatManager.unreserve(2); // Unreserve seat 2, so now the available seats are [2,3,4,5].
seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
seatManager.reserve();    // The available seats are [3,4,5], so return the lowest of them, which is 3.
seatManager.reserve();    // The available seats are [4,5], so return the lowest of them, which is 4.
seatManager.reserve();    // The only available seat is seat 5, so return 5.
seatManager.unreserve(5); // Unreserve seat 5, so now the available seats are [5].


Constraints:

1 <= n <= 105
1 <= seatNumber <= n
For each call to reserve, it is guaranteed that there will be at least one unreserved seat.
For each call to unreserve, it is guaranteed that seatNumber will be reserved.
At most 105 calls in total will be made to reserve and unreserve.


3. Sorted Set:
Like min-heap, we can use another advanced built-in data structure, the sorted set, to help dynamically maintain the ordered state of the reserved seat.

This data structure internally uses a height-balanced binary search tree (like, a red-black tree, AVL tree, etc.) to keep the data sorted. Thus, pushing an element, popping an element, and getting the minimum-valued element are all logarithmic time operations because the tree balances itself after each operation.

You can read more about Height-Balanced BST in our explore card.

Thus, in this approach, we will implement the previous approach using a sorted set.

You can also implement the first approach using a sorted set.

Note: The sorted set approach is not expected during the interview, but we are including it here for the completeness of the article and to familiarize you with a built-in advanced data structure.

Complexity Analysis
Let mmm be the maximum number of calls made.

Time complexity: O(m⋅logn)

While initializing the SeatManager object, we perform constant time operations.
In the reserve() method, we pop the minimum-valued element from the availableSeats set which takes O(logn) time.
In the unreserve(seatNumber) method, we push the seatNumber into the availableSeats set which will also take O(logn) time.
There are a maximum of m calls to reserve() or unreserve() methods, thus the overall time complexity isO(m⋅logn).
Space complexity: O(n)

The availableSeats set can contain nnn elements in it. So in the worst case, it will take O(n) space.
 */