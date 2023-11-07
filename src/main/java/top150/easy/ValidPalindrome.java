package top150.easy;

import javax.xml.stream.events.Characters;
import java.util.Locale;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

//    two pointer; time: O(n), space: O(1)
    public static boolean isPalindrome(String s) {
        for(int i = 0, j = s.length() - 1 ; i < j ; i++, j--) {
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) {
               i++;
            }
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
        }
        return true;
    }

//    Using string builder reverse
    public static boolean isPalindrome1(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        String filteredString = sb.toString();
        String reversedString = sb.reverse().toString();
        return filteredString.equals(reversedString);
    }

    public static boolean isPalindromeUsingStreams(String s) {
        StringBuilder builder = new StringBuilder();
        s.chars()
                .filter(c -> Character.isLetterOrDigit(c))
                .mapToObj(c -> Character.toLowerCase((char)c))
                .forEach(builder::append);
        return builder.toString().equals(builder.reverse().toString());
    }

//    inital; (expensive unnecessary conversion we did :p)
    public static boolean isPalindrome2(String s) {
        String pattern = "[^A-Za-z0-9]";
        String s1 = s.toLowerCase().replaceAll(pattern,"");
        int n = s1.length();
        for(int i = 0 ; i < n/2 ; i++) {
            if(s1.charAt(i) != s1.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.



Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.


Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */