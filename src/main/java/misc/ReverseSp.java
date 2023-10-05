package misc;

import java.util.Arrays;

public class ReverseSp {
    public static void main(String[] args) {
        String str = "ab-cd";
        String str1 = "a-bcd!!";
        String res = reverseSp(str1);
        System.out.println(res);
    }
    public static String reverseSp(String str) {
        StringBuilder sb = new StringBuilder();
        String[] ar = str.split("");
        int len = str.length();
        int j = len - 1;
        for(int i = 0 ; i < len/2 ; i++) {
            if(!(ar[i].matches("[a-zA-Z]+"))) continue;
            while(!(ar[j].matches("[a-zA-Z]+")))  j--;
            if(j > i) {
                String temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
                j--;
            }
        }
        Arrays.stream(ar).forEach(s->sb.append(s));
        return sb.toString();
    }
}

/*
Reverse a string's letter if it is a "letter" else leave it as it is.
input = "ab-cd"
output = "dc-ba"

input = "a-bcd!!"
output = "d-cba!!"
 */