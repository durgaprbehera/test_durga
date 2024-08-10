package programs.dynamicprograms;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LongestIncreasingSubsequence {
    /*
    Longest Increasing Subsequence
    The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence
     of a given sequence such that all elements of the subsequence are sorted in increasing order.
     For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
     https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
     */

    public static void main(String[] args){
        System.out.println(lis(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80},9 ));
    }

    private static int lis(int[] arr , int n){
        int[] lis = new int[n];
        Arrays.fill(lis,1);

        for(int i=1; i<n;i++){
            for(int j=0; j<i;j++){
                if(arr[i] > arr[j] && lis[i] < lis[j] +1)
                    lis[i] = lis[j] + 1;
            }
        }

        return Arrays.stream(lis).max().getAsInt();
    }
}
