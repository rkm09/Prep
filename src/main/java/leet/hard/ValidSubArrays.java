package leet.hard;

import java.util.Stack;

public class ValidSubArrays {
    public static void main(String[] args) {
        int[] nums = {1,3,5,2};
        int res = validSubArrays(nums);
        System.out.println(res);
    }
//    Monotonic Stack
    public static int validSubArrays(int[] nums) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < nums.length ; i++) {
            while(!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                res += i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            res += (nums.length - stack.peek());
            stack.pop();
        }

        return res;
    }

}
/*
Given an integer array nums, return the number of non-empty sub arrays with the leftmost element of the sub array not larger than other elements in the sub array.
A sub array is a contiguous part of an array.
Input: nums = [1,4,2,5,3]
Output: 11
Explanation: There are 11 valid sub arrays: [1],[4],[2],[5],[3],[1,4],[2,5],[1,4,2],[2,5,3],[1,4,2,5],[1,4,2,5,3].
Input: nums = [3,2,1]
Output: 3
Explanation: The 3 valid sub arrays are: [3],[2],[1].
Input: nums = [2,2,2]
Output: 6
Explanation: There are 6 valid sub arrays: [2],[2],[2],[2,2],[2,2],[2,2,2].


Keep popping elements from the stack until the current element becomes greater than the top element.
The diff between the current index and the stack top would be the sub array size.
For all remaining elements, the last element will be considered as the right endpoint.

Time: O(n)
We iterate over the elements in the array nums, and each element will be added to the stack only once and then popped from it.
Space: O(n)
The only space required is the stack which can have N elements in the worst-case scenario when the input is increasing.
 */