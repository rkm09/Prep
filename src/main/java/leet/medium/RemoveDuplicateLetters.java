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
Input: s = "bcabc"
Output: "abc"

Input: s = "cbacdcbc"
Output: "acdb"

 */