package leet.medium;

import java.util.*;

public class FindDiagonalOrder {
    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        for(int i = 0 ; i < arr.length ; i++) {
            List<Integer> li = new ArrayList<>();
            for(int j = 0; j < arr.length ; j++) {
                li.add(arr[i][j]);
            }
            nums.add(li);
        }
        int[] diag = findDiagonalOrder(nums);
        System.out.println(Arrays.toString(diag));
    }

//    time: O(n) since length is fixed based on constraint (is not r*c), space: O(n)
//    we iterate through each of the n integers to populate groups & then iterate again to populate ans
    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> groups = new HashMap<>();
        int rowSize = nums.size();
        int diagSize = 0;
        for(int row = rowSize - 1 ; row >= 0 ; row--) {
            int colSize = nums.get(row).size();
            for(int col = 0 ; col < colSize ; col++) {
                int diagonal = row + col;
                if(!groups.containsKey(diagonal)) {
                    groups.put(diagonal, new ArrayList<>());
                }
                groups.get(diagonal).add(nums.get(row).get(col));
                diagSize++;
            }
        }
        int[] ans = new int[diagSize];
        int curr = 0; int i = 0;
        while(groups.containsKey(curr)) {
            for(int num : groups.get(curr)) {
                ans[i++] = num;
            }
            curr++;
        }
        return ans;
    }
}

/*
Given a 2D integer array nums, return all elements of nums in diagonal order as shown in the below images.
Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,4,2,7,5,3,8,6,9]
Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
Constraints:
1 <= nums.length <= 105
1 <= nums[i].length <= 105
1 <= sum(nums[i].length) <= 105
1 <= nums[i][j] <= 105

Approach1: Hashmap
For each square, we will use the sum row + col as an identifier to the diagonal that it belongs to. We will use a hash map groups where groups[x] is a list of all values that appear in the diagonal with identifier x.
To collect the cells on each diagonal in the correct order, we will iterate through each row from left to right starting with the bottom row. The reason we choose the bottom-up, left-to-right order is that the diagonals move upward and to the right, so by iterating to the upper right, we will visit the squares in the correct order.


 */