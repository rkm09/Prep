package leet.simple;

import java.util.*;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean b = isSubsequence(s,t);
        System.out.println(b);
    }
//    sliding window / 2 pointer
    public static boolean isSubsequence(String s, String t) {
        int i = 0 ; int j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++; j++;
            } else j++;
        }
        return i == s.length();
    }
}

/*
Input: s = "abc", t = "ahbgdc"
Output: true
 */