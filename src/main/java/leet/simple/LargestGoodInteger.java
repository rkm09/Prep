package leet.simple;

import java.util.List;

public class LargestGoodInteger {
    public static void main(String[] args) {
        String num = "6777133339";
        System.out.println(largestGoodInteger2(num));
    }

//    time: O(n), space: O(1) [more generic than the next approach, but slightly slower]
    public static String largestGoodInteger2(String num) {
//        smallest ascii char
        char maxdigit = '\0';
        for(int i = 0 ; i <= num.length() - 3 ; i++) {
            if(num.charAt(i) == num.charAt(i+1)
                    && num.charAt(i+1) == num.charAt(i+2)) {
                maxdigit = (char) Math.max(maxdigit, num.charAt(i));
            }
        }
        return maxdigit == '\0' ? "" : new String(new char[]{maxdigit, maxdigit, maxdigit});
    }

//    time: O(n), space: O(1)
    public static String largestGoodInteger1(String num) {
        List<String> nums = List.of("999","888","777","666","555","444","333","222","111","000");
        for(String pattern : nums) {
//            default string contains method available yet implementing it here as leetcode has it that way
//            if(num.contains(k)) return k;
            if(containsString(num, pattern)) return pattern;
        }
        return "";
    }
    public static boolean containsString(String num, String pattern) {
        for(int i = 0 ; i <= num.length() - 3 ; i++) {
            if(num.charAt(i) == pattern.charAt(0)
            && num.charAt(i+1) == pattern.charAt(1)
            && num.charAt(i+2) == pattern.charAt(2)) {
                return true;
            }
        }
        return false;
    }

//    [def] :|
    public static String largestGoodInteger(String num) {
        int count = 0, ans = -1, digit = 0;
        for(Character c : num.toCharArray()) {
            if(count == 0) {
                digit = c - '0';
                count++;
            } else {
                count++;
                if(digit != c - '0') {
                    digit = c - '0';
                    count = 1;
                } else {
                    if(count == 4) {
                        count = 1;
                    } else if(count == 3) {
                        ans = Math.max(ans, digit);
                    }
                }
            }
        }
        String good = ans == -1 ? "" : (ans + "" + ans + "" + ans);
        return good;
    }
}

/*
You are given a string num representing a large integer. An integer is good if it meets the following conditions:
It is a substring of num with length 3.
It consists of only one unique digit.
Return the maximum good integer as a string or an empty string "" if no such integer exists.
Note:
A substring is a contiguous sequence of characters within a string.
There may be leading zeroes in num or a good integer.
Example 1:
Input: num = "6777133339"
Output: "777"
Explanation: There are two distinct good integers: "777" and "333".
"777" is the largest, so we return "777".
Example 2:

Input: num = "2300019"
Output: "000"
Explanation: "000" is the only good integer.
Example 3:

Input: num = "42352338"
Output: ""
Explanation: No substring of length 3 consists of only one unique digit. Therefore, there are no good integers.


Constraints:

3 <= num.length <= 1000
num only consists of digits.
 */