package misc;

import java.util.Stack;

public class ValidPar {
    public static void main(String[] args){
        String s = "(){}[]";
        boolean res = isValid(s);
        System.out.println(res);
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') stack.push(c);
            else {
                if((c == ')' && stack.peek() == '(') || (c == '}' && stack.peek() == '{') || (c == ']' && stack.peek() == '[')) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
