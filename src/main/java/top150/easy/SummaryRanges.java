package top150.easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {1,3};
        System.out.println(summaryRanges1(nums));
    }

//    time: O(n), space: O(1)
    public static List<String> summaryRanges1(int[] nums) {
        List<String> ranges = new ArrayList<>();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++) {
            int start = nums[i];
            while(i + 1 < n && nums[i] + 1 == nums[i+1]) {
                i++;
            }
            if(start == nums[i]) {
                ranges.add(String.valueOf(start));
            } else {
                ranges.add(start + "->" + nums[i]);
            }
        }
        return ranges;
    }

//    def :p
    public static List<String> summaryRanges(int[] nums) {
        List<String> range = new ArrayList<>();
        int n = nums.length;
        if(n < 1) return range;
        if(n == 1) {
            range.add(String.valueOf(nums[0]));
            return range;
        }
        int first = 0;
        for(int last = 1 ; last < n; last++) {
            int prev = last - 1;
            if(nums[last] - nums[prev] == 1) {
               if(last != n - 1) continue;
               range.add(nums[first] + "->" + nums[last]);
            } else {
                if(first == prev) {
                    range.add(String.valueOf(nums[first]));
                    first = prev + 1;
                } else {
                    range.add(nums[first] + "->" + nums[prev]);
                    first = prev + 1;
                }
                if(last == n - 1) {
                    range.add(String.valueOf(nums[last]));
                }
            }
        }
        return range;
    }
}

/*
You are given a sorted unique integer array nums.
A range [a,b] is the set of all integers from a to b (inclusive).
Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
Each range [a,b] in the list should be output as:
"a->b" if a != b
"a" if a == b
Example 1:
Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
Example 2:
Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
Constraints:

0 <= nums.length <= 20
-231 <= nums[i] <= 231 - 1
All the values of nums are unique.
nums is sorted in ascending order.
 */