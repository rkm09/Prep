package leet.simple;

public class ReverseString {
    public static void main(String[] args) {
        String str = "perfect";
//        reverseString(str);
//        reverseUsingSB(str);
        reverseManuallyWithSb(str);
    }
    public static void reverseString(String str) {
        String[] strAr = str.split("");
        String temp = "";
        for(int i = 0; i < strAr.length/2 ; i++) {
            temp = strAr[i];
            strAr[i] = strAr[strAr.length-i-1];
            strAr[strAr.length-i-1] = temp;
        }
        for(String s : strAr) System.out.print(s);
    }

    public static void reverseUsingSB(String str) {
        String result = new StringBuilder(str)
                .reverse().toString();
        System.out.println(result);
    }

    public static void reverseManuallyWithSb(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = str.length() - 1 ; i >= 0 ; i--) {
            sb.append(str.charAt(i));
        }
        System.out.println(sb.toString());
    }

}
