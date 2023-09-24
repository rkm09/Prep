package leet.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;


public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] res = nextGreaterElement2(nums1, nums2);
        Arrays.stream(res).forEach(System.out::println);
    }
//    basic brute force
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int j;
        for(int i = 0 ; i < nums1.length ; i++) {
            boolean found = false;
            for(j = 0 ; j < nums2.length ; j++) {
                if(found && nums2[j] > nums1[i]) { res[i] = nums2[j]; break;}
                if(nums1[i] == nums2[j]) found = true;
            } if(j == nums2.length) res[i] = -1;
        }
        return res;
    }
//        better brute force
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int j;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0 ; i < nums2.length ; i++) {
            hm.put(nums2[i],i);
        }
        for(int i = 0 ; i < nums1.length ; i++) {
            for(j = hm.get(nums1[i]) ; j < nums2.length ; j++) {
                if(nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
            } if(j == nums2.length) res[i] = -1;
        }
        return res;
    }
    //    Stack approach
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int res[] = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0 ; i < nums2.length ; i++) {
            while(!stack.isEmpty() && nums2[i] > stack.peek()) hm.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }
        while(!stack.empty())
            hm.put(stack.pop(), -1);

        for(int i = 0 ; i < nums1.length ; i++) {
            res[i] = hm.get(nums1[i]);
        }

        return res;
    }

}
/*
The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]

Complexity:
ap 1 : time: O(m*n) , space: O(1)
ap2: time: O(m*n) , space: O(n) in practice, this algorithm will be faster than the previous one, since here we don't need to scan nums2nums2nums2 to find the position of nums1[i]nums1[i]nums1[i] element.
ap3: time: O(n), space: O(n) (for map)
The entire nums2 array (of size n) is scanned only once. Each of the stack's n elements are pushed and popped
exactly once. The nums1 array is also scanned only once. All together this requires O(n+n+m) time. Since nums1 must be a subset of nums2, we know m must be less than or equal to n. Therefore, the time complexity can be simplified to O(n).
 */