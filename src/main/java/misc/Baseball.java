package misc;

import java.util.Stack;

public class Baseball {
    public static void main(String[] args) {
        String[] ops = {"5", "2", "C", "D", "+"};
        int res = calPoints(ops);
        String ops1 = "52CD+";
        System.out.println(res);
        int res1 = calPoints1(ops1);
        System.out.println(res1);
        char c = '5';
        int r = c - '0';
        System.out.println("**");
        System.out.println(r);
    }

    public static int calPoints(String[] ops) {
        int res = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].matches("[0-9]")) stack.push(Integer.valueOf(ops[i]));
            else {
                if (ops[i].equals("C")) stack.pop();
                else if (ops[i].equals("D")) stack.push(stack.peek() * 2);
                else if (ops[i].equals("+")) {
                    int temp1 = stack.pop();
                    int temp2 = stack.peek() + temp1;
                    stack.push(temp1);
                    stack.push(temp2);
                }
            }
        }
        while (!stack.empty()) {
            res += stack.pop();
        }
        return res;
    }

    public static int calPoints1(String ops) {
        int res = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < ops.length(); i++) {
            char c = ops.charAt(i);
            if (Character.isDigit(c)) stack.push(c - '0');
            else {
                if (c == 'C') stack.pop();
                else if (c == 'D') stack.push(stack.peek() * 2);
                else if (c == '+') {
                    int temp1 = stack.pop();
                    int temp2 = stack.peek() + temp1;
                    stack.push(temp1);
                    stack.push(temp2);
                }
            }
        }
        while (!stack.empty()) {
            res += stack.pop();
        }
        return res;
    }
}


// character to int --> either (c - '0') OR Integer.parseInt(String.valueOf(char))