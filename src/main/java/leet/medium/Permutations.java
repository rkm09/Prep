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
 */
