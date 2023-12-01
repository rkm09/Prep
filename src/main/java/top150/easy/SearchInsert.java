package top150.easy;

public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;
        System.out.println(searchInsert1(nums, target));
    }

// binary search; time: O(logn), space: O(1)
    public static int searchInsert1(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while(left <= right) {
//            to prevent integer overflow, we could also use: (left + right) >> 1
            int pivot = left + (right - left) / 2;
            if(nums[pivot] == target) return pivot;
            if(nums[pivot] < target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return left;
    }

//  binary search; def;
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while(n > 0) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
            n /= 2;
        }
        return left;
    }
}

/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.
Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4
Constraints:
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104

Binary search is a search algorithm that finds the position of a target value within a sorted array.
Integer Overflow:
Let us now stress the fact that pivot = (left + right) / 2 works is fine for Python3, which has arbitrary precision integers, but it could cause some issues in Java and C++.
If left + right is greater than the maximum int value 2^31−1, it overflows to a negative value. In Java, it would trigger an ArrayIndexOutOfBoundsException, and in C++ it causes an illegal write, which leads to memory corruption and unpredictable results.
 */