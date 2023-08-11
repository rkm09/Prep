package leet.simple;

import java.util.ArrayList;
import java.util.List;

public class sim1 {
    public static void main(String[] args) {
        String s1 = "";
        System.out.println(s1.isBlank());
        String s2 = null;
//        System.out.println(s2.isEmpty());

        List<String> strList = new ArrayList<>();
        strList.add("banana");
        strList.add("apple");
        strList.add("grapes");
        strList.add("mango");

        List<String> strList2 = strList.subList(0,strList.size()-1);
        strList2.forEach(System.out::println);
    }
}
