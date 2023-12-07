package top150.easy;

public class LongestCommonSubsequence14 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix3(strs));
    }

//    horizontal scanning O(m*n)
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for(int i = 1 ; i < strs.length ; i++) {
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

//    vertical scanning
    public static String longestCommonPrefix1(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        for(int i = 0 ; i < strs[0].length() ; i++) {
            char c = strs[0].charAt(i);
            for(int j = 1 ; j < strs.length ; j++) {
                if(i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    //    binary search; time: O(m*nlogn), space: O(1)
    public static String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        int minLength = Integer.MAX_VALUE;
        for(String s : strs) {
            minLength = Math.min(s.length(), minLength);
        }
        int low = 1;
        int high = minLength;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(isCommonPrefix(strs, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, (low + high)/2);
//        or low - 1 or high
    }

    private static boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for(int i = 1 ; i < strs.length; i++) {
            if(!strs[i].startsWith(str1)) {
                return false;
            }
        }
        return true;
    }

    //    divide & conquer; time: O(m*n); space: O(mlogn) [ logn recursive calls, each use m space to store result
    public static String longestCommonPrefix3(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private static String longestCommonPrefix(String[] strs, int l, int r) {
        if(l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            String lcpLeft = longestCommonPrefix(strs, l, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    private static String commonPrefix(String left, String right) {
        int minLength = Math.min(left.length(), right.length());
        for(int i = 0 ; i < minLength ; i++) {
            if(left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, minLength);
    }
}

/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.


Approach1 :
Time complexity : O(S) , where S is the sum of all characters in all strings. (m*n) [not sure of the accuracy of complexity]
In the worst case all n strings are the same. The algorithm compares the string S1 with the other strings [S2…Sn]
There are S character comparisons, where S is the sum of all characters in the input array.
Space complexity : O(1)

Complexity Analysis (binary search)
In the worst case we have n equal strings with length m
Time complexity : O(S⋅logm), where SSS is the sum of all characters in all strings.
The algorithm makes mlogm iterations, for each of them there are S=m⋅n comparisons, which gives in total O(S⋅logm) time complexity.
Space complexity : O(1). We only used constant extra space.
 */