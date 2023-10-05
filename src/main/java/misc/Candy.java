package misc;


import java.util.HashMap;
import java.util.Map;


/*
Candy Store:
input: jar = [5,8,5,8,8,8];
Output: 3
6 candies=> 6 / 2 = 3 pairs : (8,8), (5,5), (8,8)
return number of boxes if all same flavored candies distributed, else -1 (initial count 2*n) arrange into n such pairs
such that each pair has the same flavor
 */
public class Candy {
    public static void main(String[] args) {
        int[] jar = {5,8,5,8,8,8};
//        int[] jar = {1,2,3,4};
        int res = candy(jar);
        System.out.println(res);
    }
    public static int candy(int[] jar) {
        HashMap<Integer, Integer> hm  = new HashMap();
        int res = 0;
        for(int i = 0 ; i < jar.length ; i++) {
            if(!hm.isEmpty() && hm.containsKey(jar[i])) {
                hm.put(jar[i], hm.get(jar[i])+1);
            } else hm.put(jar[i], 1);
        }

        for(Map.Entry<Integer,Integer> entry: hm.entrySet()) {
            if(entry.getValue() % 2 != 0) return -1;
            else res = res + entry.getValue();
        }
        return res / 2;
    }
}
