package misc;

import java.util.ArrayList;
import java.util.List;

public class General {
    public static void main(String[] args) {
        getList();
    }
    public static void getList() {
        List<Integer> ai = new ArrayList<>();
        ai.add(1);
        ai.add(2);
        ai.add(3);
        List<Integer> ai2 = new ArrayList<>();
        ai2 = ai.subList(0, -1);
        ai2.forEach(s-> System.out.println(s));
    }
}
