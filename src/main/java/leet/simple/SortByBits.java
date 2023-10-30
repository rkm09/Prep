package leet.simple;

import java.util.Arrays;
import java.util.Comparator;

public class SortByBits {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8};
        int[] res = sortByBits(arr);
        System.out.println(Arrays.toString(res));
    }

//    bitwise manipulation; time: O(nlog n), space: O(log n)
    public static int[] sortByBits(int[] arr) {
        Integer[] sortBits = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        CustomComparator comparator = new CustomComparator();
        Arrays.sort(sortBits, comparator);
        return Arrays.stream(sortBits).mapToInt(Integer::intValue).toArray();
    }

}

class CustomComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        if(findWeight(a) == findWeight(b)) {
            return a - b;
        }
        return findWeight(a) - findWeight(b);
    }

//    brian Kerninghan's method; tim: O(nlogn), space: O(n)
    private int findWeight(int num) {
        int weight = 0;
        while(num > 0) {
            weight++;
            num &= num - 1;
        }
        return weight;
    }

    private int findWeight1(int num) {
        int mask = 1;
        int weight = 0;

        while(num > 0) {
            if((num & mask) > 0) {
                weight++;
                num ^= mask;
            }
            mask <<= 1;
        }

        return weight;
    }

}

//    Using built in methods (not expected to use in an interview :p); time: O(nlog n), space: O(log n)
class CustomComparator1 implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        if (Integer.bitCount(a) == Integer.bitCount(b)) {
            return a - b;
        }
        return Integer.bitCount(a) - Integer.bitCount(b);
    }

}
/*
You are given an integer array arr. Sort the integers in the array in ascending order by the number of 1's in their binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.

Return the array after sorting it.
Example 1:

Input: arr = [0,1,2,3,4,5,6,7,8]
Output: [0,1,2,4,8,3,5,6,7]
Explantion: [0] is the only integer with 0 bits.
[1,2,4,8] all have 1 bit.
[3,5,6] have 2 bits.
[7] has 3 bits.
The sorted array by bits is [0,1,2,4,8,3,5,6,7]
Example 2:

Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
Output: [1,2,4,8,16,32,64,128,256,512,1024]
Explantion: All integers have 1 bit in the binary representation, you should just sort them in ascending order.


Constraints:

1 <= arr.length <= 500
0 <= arr[i] <= 104


To find the hamming weight of a number, we can use what is called a mask. This mask will have a single set bit, initially the least significant one (representing the number 1, at position 0). We will AND this mask with the number, and if the result is non-zero, it means the bit is set in the number. We can thus increment the hamming weight by 1 and then continue to the next position by left-shifting the mask, which moves the single bit over to the next position (this is the same as multiplying it by two).

There are two ways we can end this process.

1. Iterate 31 times (since this is the maximum size of an integer)
2. When we find a set bit in the number, flip it to a 0 (with XOR). When the number becomes 0, then we know there are no more set bits and can end.
The second option is better since we will terminate as soon as possible, whereas the first option will always iterate 31 times, regardless of the size of the number.
Given nnn as the length of arr,

Time complexity: O(n⋅logn)

Finding the hamming weight of a number is dependent on the size of a number, but as we are dealing with integers that have a fixed size (31 bits), we can consider it as an O(1) operation. Sorting arr costs O(n⋅logn).

Space Complexity: O(logn) or O(n)
 */