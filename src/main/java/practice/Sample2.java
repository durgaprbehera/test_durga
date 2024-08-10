package practice;

import java.util.Arrays;
import java.util.Collections;

public class Sample2 {

    public static void main(String[] args){
        //System.out.println("Hello");
        int a[] = {1,2,3,4,5};
        secondLargest(a);
    }

    public static void secondLargest(int[] a){
        Arrays.sort(a);
        int n = a.length;
        System.out.println(a[n-2]);
    }
}
