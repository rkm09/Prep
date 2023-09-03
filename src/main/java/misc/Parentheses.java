package misc;

import java.util.Scanner;
import java.util.Stack;

/*
{},(),[]
 */
public class Parentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(isValid(s)) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }
    }
    public static boolean isValid(String s) {
        boolean result  = false;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length() ; i++) {
            if(s.charAt(i) == '(') {
                stack.push('(');
            } else if(s.charAt(i) == '{') {
                stack.push('{');
            } else if(s.charAt(i) == '[') {
                stack.push('[');
            } else if(s.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
            } else if(s.charAt(i) == '}' && stack.peek() == '{') {
                stack.pop();
            } else if(s.charAt(i) == ']' && stack.peek() == '[') {
                stack.pop();
            }
        }
        result = stack.empty();
        return result;
    }
}
