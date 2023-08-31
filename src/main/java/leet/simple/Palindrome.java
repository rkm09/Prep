package leet.simple;

/*
Given an integer x, return true if x is a
palindrome
, and false otherwise.
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
 */
public class Palindrome {
    public static void main(String[] args) {
        // simple way with non constant space: convert to string and compare
        // approach 2: directly dealing with numbers
//        boolean res = isPalindromeStringVersion(-121);
        boolean res = isPalindrome(121);
        System.out.println(res);
    }

    public static boolean isPalindrome(int x) {
//        time: O(log base 10 n), space: O(1)
        int reverted = 0;
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        while(reverted < x) {
            reverted = reverted * 10 + x % 10;
            x /= 10;
        }
        return reverted == x || x == reverted / 10;
    }

    public static boolean isPalindromeStringVersion(int x) {
//        time: O(n), space: O(n)
        String str = String.valueOf(x);
        for(int i = 0 ; i <  str.length()/2 ; i++) {
            if(str.charAt(i) == str.charAt(str.length() - i - 1)) continue;
            else return false;
        }
        return true;
    }
}
