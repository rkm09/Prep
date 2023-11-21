package leet.medium;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class FindUniqueBinString {
    public static void main(String[] args) {
        String[] nums = {"111","011","000"};
        String ans = findDifferentBinaryString3(nums);
        System.out.println(ans);
    }

//    Cantor's diagonal argument; time: O(n), space: O(1)
    public static String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for(int i = 0 ; i < nums.length ; i++) {
            Character curr = nums[i].charAt(i);
            ans.append(curr == '0' ? '1' : '0');
        }
        return ans.toString();
    }

//  iterative; time: O(n^2) [iterate num in range(n) then if found convert to binary(n) => n^2], space: O(n)
    public static String findDifferentBinaryString1(String[] nums) {
        Set<Integer> integers = new HashSet<>();
        for(String num : nums) {
            integers.add(Integer.parseInt(num, 2));
        }
        int n = nums.length;
//        considering n+1 combination (0-n) atleast 1 will not be present
        for(int num = 0 ; num <= n ; num++) {
            if(!integers.contains(num)) {
                String ans = Integer.toBinaryString(num);
                while(ans.length() < n) {
                    ans = "0" + ans;
                }
                return ans;
            }
        }
        return "";
    }

//    random; slower than the other two
    public static String findDifferentBinaryString2(String[] nums) {
        Set<Integer> integers = new HashSet<>();
        for(String num : nums) {
            integers.add(Integer.parseInt(num, 2));
        }
        Random rand = new Random();
        int ans = Integer.parseInt(nums[0], 2);
        int n = nums.length;
        while(integers.contains(ans)) {
            ans = rand.nextInt((int) Math.pow(2, n));
        }
        String str = Integer.toBinaryString(ans);
        while(str.length() < n) {
            str = "0" + str;
        }
        return str;
    }

//    time: O(n^2), space: O(n)
    public static String findDifferentBinaryString3(String[] nums) {
        int n = nums.length;
        Set<String> numSet = new HashSet<>();
        for(String num : nums) {
            numSet.add(num);
        }
        return generate("", numSet, n);
    }
    private static String generate(String curr, Set<String> numSet, int n) {
        if(curr.length() == n) {
            if(!numSet.contains(curr)) {
                return curr;
            }
            return "";
        }
        String addZero = generate(curr + "0", numSet, n);
        if(addZero.length() > 0) {
            return addZero;
        }
        return generate(curr + "1", numSet, n);
    }
}

/*
Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.



Example 1:

Input: nums = ["01","10"]
Output: "11"
Explanation: "11" does not appear in nums. "00" would also be correct.
Example 2:

Input: nums = ["00","01"]
Output: "11"
Explanation: "11" does not appear in nums. "10" would also be correct.
Example 3:

Input: nums = ["111","011","001"]
Output: "101"
Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.


Constraints:

n == nums.length
1 <= n <= 16
nums[i].length == n
nums[i] is either '0' or '1'.
All the strings of nums are unique.


Approach 4: Cantor's Diagonal argument
What is the point of this strategy? ans will differ from every string in at least one position. More specifically:

ans differs from nums[0] in nums[0][0].
ans differs from nums[1] in nums[1][1].
ans differs from nums[2] in nums[2][2].
...
ans differs from nums[n - 1] in nums[n - 1][n - 1].
Thus, it is guaranteed that ans does not appear in nums and is a valid answer.

This strategy is applicable because both the length of ans and the length of each string in nums are larger than or equal to n, the number of strings in nums. Therefore, we can find one unique position for each string in nums.

Complexity Analysis for recursion:
Given n as the length of nums (and the length of each binary string)
Time complexity: O(n^2)
We require O(n^2)to convert nums to a hash set.

Due to the optimization, we check O(n) binary strings in our recursion. At each call, we perform some string concatenation operations, which costs up to O(n)O(n)O(n) (unless you have mutable strings like in C++).
Space complexity: O(n)
The recursion call stack when generating strings grows to a size of O(n). The hash set uses O(n) space.

Complexity Analysis for rand:

Given n as the length of nums (and the length of each binary string),
Time complexity: O(∞)
Technically, the worst-case scenario would see the algorithm running infinitely, always selecting elements in integers. However, the probability that the algorithm runs for more than a few steps, let alone infinitely, is so low that we can assume it to be effectively 0. This probability also lowers exponentially as n increases.
For n = 16, there is an over 99.9% chance that we find an answer on the first iteration. For n = 20, we have an over 99.998% chance. Practically, this algorithm runs extremely quickly.
Space complexity: O(n)
The hash set integers has a size of nnn.
We don't count the answer as part of the space complexity.


 */