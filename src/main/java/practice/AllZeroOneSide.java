package practice;

import java.util.Arrays;

public class AllZeroOneSide {

    public static void main(String[] args){
        //Input array     =  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
        //Output array =  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]
        int[] arr = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        allZeroOneSide(arr);
    }

    public static void allZeroOneSide(int[] arr){
        Long count = Arrays.stream(arr).filter(i-> i==1).count();
        count.intValue();
        for(int i=0; i<count.intValue();i++)
            System.out.print(1);
        for(int i=0; i<arr.length-count.intValue();i++)
            System.out.print(0);
    }
}
