package leet.simple;

import java.util.*;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean b = isSubsequence3(s,t);
        System.out.println(b);
    }
//    sliding window / 2 pointer
    public static boolean isSubsequence1(String s, String t) {
        int i = 0 ; int j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++; j++;
            } else j++;
        }
        return i == s.length();
    }
//    Stack approach
    public static boolean isSubsequence2(String s, String t) {
        Stack<Character> stack = new Stack<>();
        for(int i = s.length() - 1 ; i >= 0 ; i--) {
            stack.push(s.charAt(i));
        }
        for(Character ch : t.toCharArray()) {
            if(stack.empty()) return true;
            if(ch == stack.peek()) {
                stack.pop();
            }
        }
        return stack.empty();
    }
//    Divide and conquer with greedy (recursion)
    public static boolean isSubsequence3(String s, String t) {
        int leftIndex = 0;
        int rightIndex = 0;
        return rec_subSequence(leftIndex, rightIndex, s, t);
    }
    public static boolean rec_subSequence(int leftIndex, int rightIndex, String source, String target) {
        if(leftIndex == source.length()) return true;
        if(rightIndex == target.length()) return false;
        if(source.charAt(leftIndex) == target.charAt(rightIndex)) leftIndex++;
        rightIndex++;
        return rec_subSequence(leftIndex, rightIndex, source, target);
    }
}

/*
Input: s = "abc", t = "ahbgdc"
Output: true

Recursive:(Dp, Greedy)
Time Complexity: O(∣T∣)
At each invocation of the rec_isSubsequence() function, we would consume one character from the target string and optionally one character from the source string.
The recursion ends when either of the strings becomes empty. In the worst case, we would have to scan the entire target string. As a result, the overall time complexity of the algorithm is O(∣T∣)\mathcal{O}(|T|)O(∣T∣).
Note, even when the source string is longer than the target string, the recursion would end anyway when we exhaust the target string. Hence, the number of recursions is not bounded by the length of the source string.

Space Complexity: O(∣T∣)
The recursion incurs some additional memory consumption in the function call stack. As we discussed previously, in the worst case, the recursion would happen ∣T∣|T|∣T∣ times. Therefore, the overall space complexity is O(∣T∣)\mathcal{O}(|T|)O(∣T∣).
With the optimization of tail recursion, this extra space overhead could be exempted, due to the fact that the call stack is reused for all consecutive recursions. However, Python and Java do not support tail recursion. Hence, this overhead cannot be waived.

 Iterative approach(2 pointer):

 Time: O(T), Space: O(1) We replace the recursion with iteration. In the iteration, a constant memory is consumed regardless of the input.
 */