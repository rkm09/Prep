package top150.easy;

import java.math.BigInteger;

public class AddBinary {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a, b));
    }

//    Bit by bit computation; time: O(max(m,n)), space: O(max(m,n))
    public static String addBinary(String a, String b) {
        int n = a.length(), m = b.length();
        if(n < m) return addBinary(b, a);
        int carry = 0, j = m - 1;
        StringBuilder sb = new StringBuilder();
        for(int i = n - 1 ; i > -1 ; i--) {
            if(a.charAt(i) == '1') carry++;
            if(j > - 1 && b.charAt(j--) == '1') carry++;
            if(carry % 2 == 1) sb.append('1');
            else sb.append('0');
            carry /= 2;
        }
        if(carry == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }

//    Bit manipulation; time: O(m+n), space: O(max(m,n))
    public static String addBinary1(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger carry, answer;
        BigInteger zero = new BigInteger("0",2);
        while(y.compareTo(zero) != 0) {
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);
    }

//    time: O(n+m); Number format exception for large string; doesn't work :|
    public static String addBinaryX(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }
}

/*
Given two binary strings a and b, return their sum as a binary string.
Example 1:
Input: a = "11", b = "1"
Output: "100"
Example 2:
Input: a = "1010", b = "1011"
Output: "10101"
Constraints:
1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.

Basic approach:
The overall algorithm has O(N+M) time complexity
and has two drawbacks which could be used against you during the interview.
1 . In Java this approach is limited by the length of the input strings a and b.
Once the string is long enough, the result of conversion into
integers will not fit into Integer, Long or BigInteger:
33 1-bits - and b doesn't fit into Integer.
65 1-bits - and b doesn't fit into Long.
500000001 1-bits - and b doesn't fit into BigInteger.
To fix the issue, one could use standard Bit-by-Bit Computation approach
which is suitable for quite long input strings.
2 . This method has quite low performance in the case of large input
numbers.
One could use Bit Manipulation approach to speed up the solution.


Bit Manipulation:

There is an interview tip for bit manipulation problems:
if you don't know how to start, start from computing XOR for your input data.
Strangely, that helps to go out for quite a lot of problems.
Here XOR is a key as well, because it's a sum of two binaries
without taking carry into account.
To find current carry is quite easy as well, it's AND of two input numbers,
shifted one bit to the left.

Now the problem is reduced: one has to find the sum of
answer without carry and carry. It's the same problem - to sum two numbers,
and hence one could solve it in a loop with the condition statement
"while carry is not equal to zero".

Performance Discussion

Here we deal with input numbers which are greater than 2^100.
That forces to use slow BigInteger
in Java, and hence the performance gain will be present for the Python solution only.
Provided here Java solution could make its best with Integers or Longs, but not
with BigIntegers.



 */