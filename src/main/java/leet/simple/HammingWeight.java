package leet.simple;

public class HammingWeight {
    public static void main(String[] args) {
        int res = hammingWeight1(5);
        System.out.println(res);
    }
//     Loop and flip :
//    (a logical AND between any number and the mask 1 gives the least significant bit of this number)
    public static int hammingWeight(int n) {
        int mask = 1;
        int weight = 0;
        for(int i = 0 ; i < 32 ; i++) {
            if((n & mask) != 0) weight++;
            mask <<= 1;
        }
        return weight;
    }
//    Bit Manipulation:
//    AND-ing n and n−1 flips the least-significant 1-bit to 0
    public static int hammingWeight1(int n) {
        int weight = 0;
        while(n != 0) {
            weight++;
            n &= (n-1);
        }
        return weight;
    }
}
/*
Write a function that takes the binary representation of an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
Input: n = 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
Time: O(1)
The run time depends on the number of bits in n.
Because n in this piece of code is a 32-bit integer, the time complexity is O(1).
The space complexity is O(1), since no additional space is allocated.


 */
