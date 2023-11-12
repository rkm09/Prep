package top150.easy;

public class ReverseBits {
    public static void main(String[] args) {
        int n = 12345678;
        System.out.println(reverseBits(n));
    }
    // you need treat n as an unsigned value
//    divide and conquer; time: O(1), space: O(1)
    public static int reverseBits(int n) {
        n = ((n & 0xffff0000) >>> 16) | ((n & 0x0000ffff) << 16);  // 2 byte swap [divide 32 by half O(log32) number of operations..=> 5]
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8); // 1 byte swap
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4); // 4 bits swap
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2); // 2 bits swap
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1); // 1 bit swap
        return n;
    }
}

/*
Reverse bits of a given 32 bits unsigned integer.
Note:
Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
Example 1:
Input: n = 00000010100101000001111010011100
Output:    964176192 (00111001011110000010100101000000)
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
Example 2:

Input: n = 11111111111111111111111111111101
Output:   3221225471 (10111111111111111111111111111111)
Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.


Constraints:

The input must be a binary string of length 32


Follow up: If this function is called many times, how would you optimize it?

logical >>> right shift doesn't preserve sign while arithmetic >> does;
The process will be as follows:
12345678 --> original number

56781234
78563412
87654321 --> desired number(reversed number)

 */