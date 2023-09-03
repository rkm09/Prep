package misc;

import java.util.ArrayList;
import java.util.List;

public class Football { // 5 -2 -4 9 5
    public static void main(String[] args) {
        String[] ops = "5 -2 4 C D 9 +".split(" ");
        int result = calPoints(ops);
        System.out.println(result);
    }
    public static int calPoints(String[] ops) {
        int result = Integer.MIN_VALUE;
        result = 0;
        List<String> li = new ArrayList<>();
        for(int i = 0 ; i < ops.length ; i++) {
            if(ops[i].equals("C")){
                li.remove(li.get(li.size()-1));
            } else if(ops[i].equals("D")) {
                li.add(String.valueOf(Integer.valueOf(li.get(li.size()-1)) * 2));
            } else if(ops[i].equals("+")) {
                li.add(String.valueOf(Integer.valueOf(li.get(li.size()-1)) + Integer.valueOf(li.get(li.size()-2))));
            }
            else li.add(ops[i]);
        }
        for(String s: li) {
            result += Integer.valueOf(s);
        }
        return result;
    }
}
