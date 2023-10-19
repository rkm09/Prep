package leet.simple;

import java.util.Stack;

public class BackspaceCompare {
    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        boolean res = backspaceCompare1(s, t);
        System.out.println(res);
    }

//    2 pointer; time: O(m+n), space: O(1)
    public static boolean backspaceCompare1(String s, String t) {
        int i = s.length() - 1 , j = t.length() - 1;
        int skipS = 0 , skipT = 0;
        while(i >= 0 ||  j >= 0) {
            while(i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                }
                else break;
            }
            while(j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                }
                else break;
            }
//            without any hash overhead the char must be same
            if((i >= 0 && j >= 0) && s.charAt(i) != t.charAt(j))
                return false;
//            one empty, the other non empty
            if((i >= 0) != (j >= 0))
                return false;
            
            i--;j--;
        }
        return true;
    }

//    via stack; time: O(m+n) where m & n is the length of s & t; space: O(m+n)
    public static boolean backspaceCompare2(String s, String t) {
        return build(s).equals(build(t));
    }
    public static String build(String str) {
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if(c != '#')
                stack.push(c);
            else if(!stack.empty())
                stack.pop();
        }
        return String.valueOf(stack);
    }
}

/*
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".

Example 3:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".


Constraints:
1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.


Follow up: Can you solve it in O(n) time and O(1) space?



 */
