package practice;

import java.util.Arrays;

public class AllNumbersOneSide {
    public static void main(String[] args){
        int[] arr = {0, 1, 0, 3, 0, 0, 2, 4, 5, 0};

        int[] nonZeroElements = Arrays.stream(arr).filter(i-> i!=0).toArray();
        System.out.println(Arrays.toString(nonZeroElements));
        Arrays.stream(nonZeroElements).forEach(System.out::print);
        for(int i=0; i< arr.length- nonZeroElements.length; i++)
            System.out.print(0);
    }
}
