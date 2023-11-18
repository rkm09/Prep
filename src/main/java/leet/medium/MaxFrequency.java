package leet.medium;

import java.util.Arrays;

public class MaxFrequency {
    public static void main(String[] args) {
        int[] nums = {1,2,4};
        int k = 5;
        System.out.println(maxFrequency1(nums, k));
    }

//    adv sliding window; time: O(nlogn), space: O(n)
    public static int maxFrequency1(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        long currSum = 0;
        for(int right = 0 ; right < nums.length ; right++) {
            int target = nums[right];
            currSum += target;
            if((right - left + 1) * target - currSum > k) {
                currSum -= nums[left];
                left++;
            }
        }
        return nums.length - left;
    }

//    sliding window; time: O(nlogn), space: O(n)
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, ans = 0;
        long currSum = 0;
        for(int right = 0 ; right < nums.length ; right++) {
            int target = nums[right];
            currSum += target;
            while((right - left + 1) * target - currSum > k) {
                currSum -= nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}

/*
The frequency of an element is the number of times it occurs in an array.
You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.
Return the maximum possible frequency of an element after performing at most k operations.
Example 1:

Input: nums = [1,2,4], k = 5
Output: 3
Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
4 has a frequency of 3.
Example 2:

Input: nums = [1,4,8,13], k = 5
Output: 2
Explanation: There are multiple optimal solutions:
- Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
- Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
- Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
Example 3:

Input: nums = [3,9,6], k = 2
Output: 1

Constraints:

1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
1 <= k <= 10^5
Be careful! Given the constraints, we may run into integer overflow. Use long accordingly in Java and C++.
Notice that the only thing we care about is the length of the longest window. We don't need to know what the window itself is. As we slide the window over the array, let's say we find a valid window with a length of len. We no longer care about any windows with lengths less than len, because they could not possibly improve on our answer.
The purpose of the while loop in the previous approach is to shrink the window until it is valid again. In this approach, we will not shrink the window - we will just try to grow it as large as we can.
We will keep the same condition in the while loop that checks if the current window [left, right] is valid, but instead of using a while loop, we will just use an if statement. This means left never increases by more than 1 per iteration. Because right also increases by 1 per iteration, if we cannot find a valid window, we will simply be sliding a window with static size across the array.
However, if we add an element nums[right] to the window and the window is valid, then the if statement will not trigger, and left will not be incremented. Thus, we will increase our window size by 1. In this scenario, it implies the current window [left, right] is the best window we have seen so far.
As you can see, it is actually impossible for our window size to decrease, since each iteration increases right by 1 and left by either 0 or 1.
Because our window size cannot decrease, it also means that the size of the window always represents the length of the best window we have found so far - analogous to ans from the previous approach.
At the end of the iteration, the size of our window is n - left. We return this as the answer.
 */