package leet.simple;

import java.sql.Time;
import java.util.*;
import java.util.stream.IntStream;

public class SortByParity {
    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        int[] res = sortArrayByParity1(nums);
        Arrays.stream(res).forEach(System.out::println);
    }

//     In place, quicksort  // optimal
//    Complexity: (O(n), O(1))
//    While quicksort is O(NlogN) normally, this is O(N) because we only need one pass to sort the elements.
    public static int[] sortArrayByParity1(int[] nums) {
        int i = 0 , j = nums.length - 1;
        while(i < j) {
            if(nums[i] % 2 > nums[j] % 2) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            if(nums[i] % 2 == 0) i++;
            if(nums[j] % 2 != 0) j--;
        }
        return nums;
    }

//     Two pass ( O(n), O(n)) good runtime : 1ms
    public static int[] sortArrayByParity2(int[] nums) {
        int[] res = new int[nums.length];
        int k = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] % 2 == 0) res[k++] = nums[i];
        }
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] % 2 != 0) res[k++] = nums[i];
        }
        return res;
    }

//  Complexity: (O(NlogN), O(N)) 7ms not optimal
    public static int[] sortArrayByParity3(int[] nums) {
        Integer[] res = new Integer[nums.length];
        for(int i = 0 ; i < res.length ; i++) res[i] = nums[i];
        Arrays.sort(res, Comparator.comparingInt(a -> a % 2));
//        Arrays.sort(res, (a,b)-> Integer.compare(a%2,b%2))
        for(int j = 0 ; j < res.length ; j++) nums[j] = res[j];
        return nums;
    }


    //      1st solution though not optimal :p 4ms
    public static int[] sortArrayByParity4(int[] nums) {
        int[] res = new int[nums.length];
        List<Integer> li = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums.length ; i++) {
            while(!stack.empty() && nums[i] % 2 != 0 && stack.peek() % 2 == 0) {
                li.add(stack.pop());
            }
            stack.push(nums[i]);
        }
        while(!stack.empty()) li.add(stack.pop());
        for(int i = 0 ; i < li.size() ; i++) {
            res[i] = li.get(i);
        }
        return res;
    }

    //        using streams one liner, but bad runtime 10ms.. not optimal
    public static int[] sortArrayByParity5(int[] nums) {
        return IntStream.concat(Arrays.stream(nums).filter(s->s%2==0), Arrays.stream(nums).filter(s->s%2!=0)).toArray();
    }
}
/*
Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
Input: nums = [0]
Output: [0]
Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
Return any array that satisfies this condition.
Constraints:
1 <= nums.length <= 5000
0 <= nums[i] <= 5000
 */