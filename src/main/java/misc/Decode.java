package misc;

public class Decode {
    public static void main(String[] args) {
        int[] k = {1,2,3,4};
        int x = 2;
        int[] res = decode(k, x);
        for(int i : res) System.out.println(i);
    }
    public static int[] decode(int[] k, int x) {
        int[] res = new int[k.length];
        int index1 = 0;
        int index2 = 0;
        for(int i = 0 ; i < k.length ; i++) {
            if(k[i] == 0) continue;
            if(x > 0) {
                index1 = (i+1) % k.length;
                index2 = (i+2) % k.length;
            } else {
                index1 = (k.length + i - 1) % k.length;
                index2 = (k.length + i - 2) % k.length;
            }
            res[i] = k[index1] + k[index2];
        }
        return res;
    }
}
/*
   k = [1,2,3,4], x = 2, output = [5,7,5,3]; each value is replaced with the next x values sum if x > 0 or prev x if x < 0 or 0 if x=0
   array cyclical
 */