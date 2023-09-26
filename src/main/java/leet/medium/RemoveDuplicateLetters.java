package leet.medium;

import java.util.*;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        String res = removeDuplicateLetters(s);
        System.out.println(res);
    }
    public static String removeDuplicateLetters(String s) {
        HashSet<Character> seen = new HashSet<>();
        HashMap<Character, Integer> lastOccurrence = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++) lastOccurrence.put(s.charAt(i), i);
        for(int i = 0 ; i < s.length() ; i++) {
            char elem = s.charAt(i);
            if(!seen.contains(elem)) {
                while(!stack.empty() && elem < stack.peek() && lastOccurrence.get(stack.peek()) > i) {
                    seen.remove(stack.pop());
                }
                seen.add(elem);
                stack.push(elem);
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for(Character c : stack) sb.append(c.charValue());
        return sb.toString();
    }
}
/*
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is
the smallest in lexicographical order among all possible results.
Input: s = "bcabc"
Output: "abc"

Input: s = "cbacdcbc"
Output: "acdb"

A string a is lexicographically smaller than a string b if in the first position where a and b differ, string a has a letter that appears earlier in the alphabet than the corresponding letter in b.
If the first min(a.length, b.length) characters do not differ, then the shorter string is the lexicographically smaller one.

(Stack solution)
Time complexity : O(n). Although there is a loop inside a loop, the time complexity is still O(n). This is because the inner while loop is bounded by the total number of elements added to the stack (each time it fires an element goes). This means that the total amount of time spent in the inner loop is bounded by O(n), giving us a total time complexity of O(n)
Space complexity : O(1). At first glance it looks like this is O(n), but that is not true! seen will only contain unique elements, so it's bounded by the number of characters in the alphabet (a constant). You can only add to stack if an element has not been seen, so stack also only consists of unique elements. This means that both stack and seen are bounded by constant, giving us O(1) space complexity.

Identical to smallest subsequence lexicographical ordering problem
 */