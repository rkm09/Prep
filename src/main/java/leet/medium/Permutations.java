package leet.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] in = {1,2,3};
        List<List<Integer>> res = permute(in);
        res.forEach(System.out::println);
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(new ArrayList<>(), res, nums);
        return res;
    }
    public static void backtrack(List<Integer> curr, List<List<Integer>> res, int[] nums) {
        if(curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int num : nums) {
            if(!curr.contains(num)) {
                curr.add(num);
                backtrack(curr, res, nums);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Constraints:
1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.

Time Complexity: O(n⋅n!)
Given a set of length n, the number of permutations is n! (n factorial).
There are n options for the first number, n−1 for the second, and so on.

*** Time complexity, better approximation: O(n2⋅(e⋅Γ(n+1,1)−n!))

Space Complexity: O(n)
We don't count the answer as part of the space complexity.
The extra space we use here is for curr and the recursion call stack.
The depth of the call stack is equal to the length of curr, which is limited to n.
 */
