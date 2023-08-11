package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionSort {
    static Integer[] nums = {5,4,3,6,1,9,3,2};
    static List<Integer> sorted;
    public static void main(String[] args) {
        insertionSort(nums);
        sorted.stream().forEach(s-> System.out.print(s + " "));
    }
    public static List<Integer> insertionSort(Integer[] nums) {
         sorted = new ArrayList();
         int temp;
         int seed;
         int a;
         for(int i = 1 ; i < nums.length ; i++) {
             seed  = nums[i];
             a = i;
            for(int j = i-1 ; j >= 0 ; j--) {
                if(seed < nums[j]) {
                    temp = nums[j];
                    nums[j] = nums[a];
                    nums[a] = temp; --a;
                }
            }
            for(Integer k : nums) {System.out.print(k + " ");}
            System.out.println();
         }
         sorted = Arrays.asList(nums);
        return sorted;
    }
}
