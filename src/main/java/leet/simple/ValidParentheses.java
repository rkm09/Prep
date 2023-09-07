package leet.simple;

import java.util.HashMap;
import java.util.Stack;

// O(n)
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "{{()}}";
//        String s = "{{{{()[]()[]{()[]()[]()[]()}}}}}";
//        Boolean b = isValidStr(s);
//        Boolean b = isValid(s);
        Boolean b = isValidWithMap(s);
        System.out.println(b);
    }
    // String version
    public static boolean isValidStr(String s) {
        int count = s.length()/2;
        while(s.length() != 0 && count >= 0){
            s = s.replaceAll("\\(\\)", "")
                    .replaceAll("\\{\\}", "")
                    .replaceAll("\\[\\]", "");
            count--;
        }
        return s.length() == 0;
    }
    // Stack version
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == '(') stack.push('(');
            else if(s.charAt(i) == '{') stack.push('{');
            else if(s.charAt(i) == '[') stack.push('[');
            else if(s.charAt(i) == ')' && stack.peek() == '(') stack.pop();
            else if(s.charAt(i) == '}' && stack.peek() == '{') stack.pop();
            else if(s.charAt(i) == ']' && stack.peek() == '[') stack.pop();
        }
        return stack.isEmpty();
    }

    // Stack version using hashmap
    public static boolean isValidWithMap(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> mapping = new HashMap<>();
        mapping.put(')','(');
        mapping.put('}','{');
        mapping.put(']','[');
        for(int i = 0 ; i < s.length() ; i++) {
            if(mapping.containsKey(s.charAt(i))) {
                if(!stack.isEmpty() && stack.peek() == mapping.get(s.charAt(i))) stack.pop();
                else return false;
                /*
                if(stack.isEmpty() || stack.pop() != mapping.get(s.charAt(i))) return false;
                 */
            } else stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }
}
