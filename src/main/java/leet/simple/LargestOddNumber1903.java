package leet.simple;

public class LargestOddNumber1903 {
    public static void main(String[] args) {
        System.out.println(largestOddNumber1("52"));
    }

//    time: O(n), space: O(1)
    public static String largestOddNumber1(String num) {
        int n = num.length();
        for(int i = n - 1 ; i >= 0 ; i--) {
            if(Character.getNumericValue(num.charAt(i)) % 2 != 0) {
                return num.substring(0, i+1);
            }
        }
        return "";
    }

//    [def] time: O(n), space: O(n)
    public static String largestOddNumber(String num) {
        char[] carr = num.toCharArray();
        int n = carr.length, index = n - 1;
        while(index >= 0) {
            if(carr[index] % 2 != 0) {
                index++;
                break;
            }
            index--;
        }
        return index == -1 ? "" : num.substring(0, index);
    }
}

/*
You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.
A substring is a contiguous sequence of characters within a string.
Example 1:
Input: num = "52"
Output: "5"
Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.
Example 2:
Input: num = "4206"
Output: ""
Explanation: There are no odd numbers in "4206".
Example 3:
Input: num = "35427"
Output: "35427"
Explanation: "35427" is already an odd number.
Constraints:
1 <= num.length <= 105
num only consists of digits and does not contain any leading zeros.
 */
