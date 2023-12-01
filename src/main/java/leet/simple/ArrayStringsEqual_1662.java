package leet.simple;

public class ArrayStringsEqual {
    public static void main(String[] args) {
        String[] word1 = {"abc", "d", "defg"};
        String[] word2 = {"abcddefg"};
        System.out.println(arrayStringsAreEqual(word1, word2));
     }

    //     def [actually won the time & space race ;-)]; time : O(N*K), space: O(N*K) faster than approach1
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int n1 = word1.length;
        int n2 = word2.length;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0 ; i < n1 ; i++) {
            sb1.append(word1[i]);
        }
        for(int i = 0 ; i < n2 ; i++) {
            sb2.append(word2[i]);
        }
        return sb1.toString().equals(sb2.toString());
    }

//     time : O(N*K), space: O(N*K) seems like compareTo is slower than the equals we use the later approach
    public static boolean arrayStringsAreEqual1(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(String str : word1) {
            sb1.append(str);
        }
        for(String str : word2) {
            sb2.append(str);
        }
        return sb1.compareTo(sb2) == 0;
    }



//   two pointer; time: O(N*K), space: O(1) ; :| slowest..just fyi
    public static boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
        int word1Pointer = 0, word2Pointer = 0;
        int string1Pointer = 0, string2Pointer = 0;
        int n1 = word1.length, n2 = word2.length;
        while(word1Pointer < n1 && word2Pointer < n2) {
            if(word1[word1Pointer].charAt(string1Pointer++) != word2[word2Pointer].charAt(string2Pointer++)) {
                return false;
            }
            if(string1Pointer == word1[word1Pointer].length()) {
                word1Pointer++;
                string1Pointer = 0;
            }
            if(string2Pointer == word2[word2Pointer].length()) {
                word2Pointer++;
                string2Pointer = 0;
            }
        }
        return (word1Pointer == n1 && word2Pointer == n2);
    }
}

/*
Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
A string is represented by an array if the array elements concatenated in order forms the string.
Example 1:
Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true
Explanation:
word1 represents string "ab" + "c" -> "abc"
word2 represents string "a" + "bc" -> "abc"
The strings are the same, so return true.
Example 2:
Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
Output: false
Example 3:
Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
Output: true
Constraints:
1 <= word1.length, word2.length <= 103
1 <= word1[i].length, word2[i].length <= 103
1 <= sum(word1[i].length), sum(word2[i].length) <= 103
word1[i] and word2[i] consist of lowercase letters.

Complexity Analysis
Here N is the number of strings in the list and K is the maximum length of a string in it.
Time complexity: O(N * K)
We iterate over each string in the arrays to append them. This cost us O(N * K) as we traversed over each character of the string to perform an append operation.
In the end, the comparison between the two strings also takes O(N * K) time.
Hence, the total time complexity is equal to O(N * K)
Space complexity: O(N * K)
We need to have two strings to store the strings represented by the arrays. Therefore, the total space complexity is equal to O(N * K).


 */