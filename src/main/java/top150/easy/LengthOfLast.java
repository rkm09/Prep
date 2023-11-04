package top150.easy;

public class LengthOfLast {
    public static void main(String[] args) {
        String s = "Hello, how are you  ";
        int len = lengthOfLastWord(s);
        System.out.println(len);
    }

//    time: O(n), space: O(1)
    public static int lengthOfLastWord(String s) {
        int p = s.length(); int length = 0;
        while(p > 0) {
            p--;
            if(s.charAt(p) != ' ') {
                length++;
            } else if(length > 0) {
                return length;
            }
        }
        return length;
    }

//    built-in fns; time: O(n), space: O(n)
    public static int lengthOfLastWord1(String s) {
        s = s.trim();
        return s.length() - s.lastIndexOf(" ") - 1;
    }

//  def..not optimal at all :p
    public static int lengthOfLastWord2(String s) {
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();
    }
}
