package leet.hard;

import java.util.Arrays;
import java.util.HashSet;

public class MinOperations {
    public static void main(String[] args) {
        int[] nums = {4,2,5,3};
        int res = minOperations1(nums);
        System.out.println(res);
    }

//  Sliding Window approach
    public static int minOperations(int[] nums) {
        int len = nums.length;
        int ans = len;

        HashSet<Integer> unique = new HashSet<>();
        for(int num : nums)
            unique.add(num);

        int[] newNums = new int[unique.size()];
        int index = 0;
        for(int num : unique)
            newNums[index++] = num;

        Arrays.sort(newNums);

        int j = 0;
        for(int i = 0 ; i < newNums.length ; i++) {
            while(j < newNums.length && newNums[j] < newNums[i] + len) {
                j++;
            }
            int continuous = j - i;
            ans = Math.min(ans, len - continuous);
        }
        return ans;
    }

//    binary search O(n log n), space: O(n)
    public static int minOperations1(int[] nums) {
        int len = nums.length;
        int ans = len;
//      remove duplicates
        HashSet<Integer> unique = new HashSet<>();
        for(int num : nums) unique.add(num);

//      sort
        int index = 0;
        int[] newNums = new int[unique.size()];
        for(int num : unique) newNums[index++] = num;
        Arrays.sort(newNums);

//      track contiguous
        for(int i = 0 ; i < newNums.length ; i++) {
            int left = newNums[i];
            int right = left + len - 1;
            int j = binarySearch(newNums, right);
            int continuous = j - i;
            ans = Math.min(ans, len - continuous);
//       len - continuous gives the non contiguous
        }
        return ans;
    }

    public static int binarySearch(int[] newNums, int target) {
        int left = 0;
        int right = newNums.length;
        while(left < right) {
            int mid = (left + right) / 2;
            if(target < newNums[mid]) {
                right = mid;
            } else
                left = mid + 1;
        }
        return left;
    }
}

/*
You are given an integer array nums. In one operation, you can replace any element in nums with any integer.

nums is considered continuous if both of the following conditions are fulfilled:

All elements in nums are unique.
The difference between the maximum element and the minimum element in nums equals nums.length - 1.
For example, nums = [4, 2, 5, 3] is continuous, but nums = [1, 2, 3, 5, 6] is not continuous.

Return the minimum number of operations to make nums continuous.



Example 1:

Input: nums = [4,2,5,3]
Output: 0
Explanation: nums is already continuous.
Example 2:

Input: nums = [1,2,3,5,6]
Output: 1
Explanation: One possible solution is to change the last element to 4.
The resulting array is [1,2,3,5,4], which is continuous.
Example 3:

Input: nums = [1,10,100,1000]
Output: 3
Explanation: One possible solution is to:
- Change the second element to 2.
- Change the third element to 3.
- Change the fourth element to 4.
The resulting array is [1,2,3,4], which is continuous.


Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109

Complexity:
Given n as the length of nums,
Time complexity: O(n⋅log n)

To remove duplicates and sort nums, we require O(n⋅log n) time.
Then, we iterate over n indices and perform O(1) amortized work at each iteration. The while loop inside the for loop can only iterate at most n times total across all iterations of the for loop. Each element in newNums can only be iterated over once by this while loop.
Despite this approach having the same time complexity as the previous approach (due to the sort), it is a slight practical improvement as the sliding window portion is O(n).

Space complexity: O(n)
We create a new array newNums of size O(n). Note that even if you were to modify the input directly, we still use O(n) space creating a hash set to remove duplicates. Also, it is considered a bad practice to modify the input, and many people will argue that modifying the input makes it part of the space complexity anyway.

Approach 1 : Sliding Window: (faster than A2)
Algorithm

Set n = nums.length and the answer ans = n.
Remove duplicates from nums and then sort it. We will call this new array newNums.
Initialize j = 0 and iterate i over the indices of newNums:
While newNums[j] is within our range (less than newNums[i] + n), increment j.
Calculate count = j - i, the number of elements already in our range.
Update ans with n - count if it is smaller.
Return ans.

Approach 2 : Binary Search
Algorithm

Set n = nums.length and the answer ans = n.
Remove duplicates from nums and then sort it. We will call this new array newNums.
Iterate i over the indices of newNums:
Set left = newNums[i].
Calculate right = left + n - 1.
Calculate j, the insertion index of right in newNums using binary search.
Calculate count = j - i, the number of elements already in our range.
Update ans with n - count if it is smaller.
Return ans.

Complexity:
Given n as the length of nums,
Time complexity: O(n⋅log n)
log n for binary search
Space: O(n) as above
 */