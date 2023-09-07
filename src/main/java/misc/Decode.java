package misc;

public class Decode {
//    k = [1,2,3,4], x = 2, output = [5,7,5,3]; each value is replaced with the next x values sum if x > 0 or prev x if x < 0 or 0 if x=0
//   array cyclical
    public static void main(String[] args) {
        int[] k = {1,2,3,4};
        int x = -2;
        int[] res = decode(k, x);
        for(int i : res) System.out.println(i);
    }
    public static int[] decode(int[] k, int x) {
        int[] res = new int[k.length];
        int len = k.length;
        for(int i = 0 ; i <  k.length ; i++) {
            res[i] = 0;
            int count = 0;
            if(x > 0) {
                while(count < x) {
                    int index = (i + 1 + count) % len;
                    res[i] += k[index];
                    ++count;
                }
            }
            else if(x < 0) {
                while(count < -x) {
                    int base = i - 1 - count ;
                    base =  (base < 0) ? (base + len) : base;
                    int index = base % len;
                    res[i] += k[index];
                    ++count;
                }
            }
        }
        return  res;
    }
}
