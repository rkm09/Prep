package leet.medium;

public class DecodeAtIndex {
    public static void main(String[] args) {
        String s = "leet2code3";
        int k = 10;
        String res = decodeAtIndex(s, k);
        System.out.println(res);
    }
    public static String decodeAtIndex(String s, int k) {
        long size = 0;
        int len = s.length();
//        get overall size
        for(int i = 0 ; i < len ; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) size *= c - '0';
            else size += 1;
        }

//        iterate backwards
        for(int i = len - 1 ; i >= 0 ; i--) {
            char c = s.charAt(i);
            k %= size;
            if(k == 0 && Character.isLetter(c)) return String.valueOf(c);
            if(Character.isDigit(c)) size /= c - '0';
            else size -= 1;
        }
        return null;
    }
}

/*
You are given an encoded string s. To decode the string to a tape, the encoded string is read one character at a time and the following steps are taken:
If the character read is a letter, that letter is written onto the tape.
If the character read is a digit d, the entire current tape is repeatedly written d - 1 more times in total.
Given an integer k, return the kth letter (1-indexed) in the decoded string.
Input: s = "leet2code3", k = 10
Output: "o"
Explanation: The decoded string is "leetleetcodeleetleetcodeleetleetcode".
The 10th letter in the string is "o".

If we have a decoded string like appleappleappleappleappleapple and an index like K = 24, the answer is the same if K = 4.
In general, when a decoded string is equal to some word with size length repeated some number of times (such as apple with size = 5 repeated 6 times), the answer is the same for the index K as it is for the index K % size.

Time: O(n)
Space: O(1)
 */