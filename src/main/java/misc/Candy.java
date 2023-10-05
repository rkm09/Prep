package misc;

import java.util.Arrays;
import java.util.Stack;

/*
Candy Store:
input: jar = [5,8,5,8,8,8];
Output: 3
6 candies=> 6 / 2 = 3 pairs : (8,8), (5,5), (8,8)
return number of boxes if all same flavored candies distributed, else -1 (initial count 2*n) arrange into n such pairs
such that each pair has the same flavor
 */
public class Candy {
    public static void main(String[] args) {
        int[] jar = {5,8,5,8,8,8};
//        int[] jar = {1,2,3,4};
        int res = candy(jar);
        System.out.println(res);
    }

    public static int candy(int[] jar) {
        int len = jar.length;
        if(len % 2 != 0) return -1;
        Arrays.sort(jar);
        Stack<Integer> stack = new Stack();
        for(int i = 0 ; i < jar.length ; i++) {
            if(!stack.empty() && stack.peek() == jar[i]) {
                stack.pop();
            }
            else stack.push(jar[i]);
        }
        if(stack.isEmpty()) return len/2;
        return -1;
    }

}
