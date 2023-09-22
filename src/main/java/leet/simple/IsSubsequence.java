package leet.simple;

import java.util.*;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean b = isSubsequence2(s,t);
        System.out.println(b);
    }
//    sliding window / 2 pointer
    public static boolean isSubsequence1(String s, String t) {
        int i = 0 ; int j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++; j++;
            } else j++;
        }
        return i == s.length();
    }
//    Stack approach
    public static boolean isSubsequence2(String s, String t) {
        Stack<Character> stack = new Stack<>();
        for(int i = s.length() - 1 ; i >= 0 ; i--) {
            stack.push(s.charAt(i));
        }
        for(Character ch : t.toCharArray()) {
            if(stack.empty()) return true;
            if(ch == stack.peek()) {
                stack.pop();
            }
        }
        return stack.empty();
    }
}

/*
Input: s = "abc", t = "ahbgdc"
Output: true
 */