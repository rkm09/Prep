package leet.hard;

public class FindInMountainArray {
    public static void main(String[] args) {
//        int[] mntArr = {1,2,3,4,5,3,1}; // target 3
//        int[] mntArr = {1,5,2}; // target 2
        int[] mntArr = {0,5,3,1}; // target 1
        int target = 4;
        MountainArrayImpl mountainArray = new MountainArrayImpl(mntArr);
        int res = findInMountainArray(target, mountainArray);
        System.out.println(res);
    }
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int begin = 0, end = length;
        int res;
//        find peak with bs
        int peakIndex = binarySearchForPeak(mountainArr, length);
//        search in ascending with bs
        end = peakIndex;
        res = binarySearchIncreasing(mountainArr, begin, end, target);
        if(mountainArr.get(res) == target) return res;
//        search in decreasing with bs
        begin = peakIndex + 1;
        end = length - 1;
        res = binarySearchDecreasing(mountainArr, begin, end, target);
        if(mountainArr.get(res) == target) return res;

        return -1;
    }

    public static int binarySearchForPeak(MountainArray mountainArr, int length) {
        int low = 0;
        int high = length - 1;
        int mid;
        while(low < high) {
            mid = (low + high) / 2;
            if(mountainArr.get(mid) < mountainArr.get(mid + 1))
                low = mid + 1;
            else high = mid;
        }
        return low;
    }
    public static int binarySearchIncreasing(MountainArray mountainArr, int low, int high, int target) {
        int mid;
        while(low < high) {
            mid = (low + high) / 2;
            if(mountainArr.get(mid) < target)
                low = mid + 1;
            else high = mid;
        }
        return low;
    }

    public static int binarySearchDecreasing(MountainArray mountainArr, int low, int high, int target) {
        int mid;
        while(low < high) {
            mid = (low + high) / 2;
            if(mountainArr.get(mid) > target)
                low = mid + 1;
            else high = mid;
        }
        return low;
    }
}


class MountainArrayImpl implements MountainArray{
    int[] arr;
    MountainArrayImpl(int[] arr) {
        this.arr = arr;
    }
    public int get(int index) {
        return arr[index];
    }
    public int length() {
        return arr.length;
    }
}

/*
You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.

You cannot access the mountain array directly. You may only access the array using a MountainArray interface:

MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.



Example 1:

Input: array = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
Example 2:

Input: array = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.


Constraints:

3 <= mountain_arr.length() <= 104
0 <= target <= 109
0 <= mountain_arr.get(index) <= 109


Complexity:
time: O(log n) base 2, space: O(1)
 */