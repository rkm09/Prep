package top150.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    static Set<Integer> seen = new HashSet<>();
    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy1(n));
    }

//    floyd's cycle; time : O(logn), space: O(1)
    public static boolean isHappy1(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while(fastRunner != 1 && fastRunner != slowRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1 ? true : false;
    }
    public static int getNext(int num) {
        int sum = 0;
        while(num > 0) {
            int d = num % 10;
            sum += d * d;
            num /= 10;
        }
        return sum;
    }


//    first approach; time: O(logn), space: O(logn)
    public static boolean isHappy(int n) {
        return getSum(n) == 1 ? true : false;
    }
    public static int getSum(int n) {
        if(n == 1) return 1;
        int sum = 0;
        while(n > 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        if(sum != 1 && !seen.contains(sum)) {
            seen.add(sum);
            sum = getSum(sum);
        }
        return sum;
    }
}

/*
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.
Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false


Constraints:

1 <= n <= 231 - 1

Time Complexity:
O(243⋅3+logn+loglogn+logloglogn)... = O(logn).
Finding the next value for a given number has a cost of O(logn) because we are processing each digit in the number, and the number of digits in a number is given by logn.

we'd expect continually following links to end in one of three ways.

It eventually gets to 111.
It eventually gets stuck in a cycle.
It keeps going higher and higher, up towards infinity.
That 3rd option sounds really annoying to detect and handle. How would we even know that it is going to continue going up, rather than eventually going back down, possibly to 1?1?1? Luckily, it turns out we don't need to worry about it. Think carefully about what the largest next number we could get for each number of digits is.
num | largest | next
1 | 9 | 81
2 | 99 | 162
3 | 999 | 243
...
For a number with 3 digits, it's impossible for it to ever go larger than 243.
This means it will have to either get stuck in a cycle below 243 or go down to 1.

 */