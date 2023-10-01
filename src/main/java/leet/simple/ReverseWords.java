package leet.simple;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class ReverseWords {
    public static void main(String[] args) {
        String s = "God Ding";
        String s1 = "Let's take LeetCode contest";
        String res = reverseWords2(s);
        System.out.println(res);
    }

//    One liner but slower
    public static String reverseWords2(String s) {
        return Arrays.stream(s.split(" "))
                .map(word -> new StringBuilder(word).reverse())
                .collect(Collectors.joining(" "));
    }

    public static String reverseWords3(String s) {
        StringBuilder sb = new StringBuilder(s);
        String s1 = sb.reverse().toString();
        String[] sarr = s1.split(" ");
        StringBuilder sb1 = new StringBuilder();
        for(int i = sarr.length - 1 ; i >= 0 ; i--) sb1.append(sarr[i]).append(" ");
        return sb1.substring(0, sb1.length() - 1);
    }
}
/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Input: s = "God Ding"
Output: "doG gniD"

Constraints:
1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.
 */
