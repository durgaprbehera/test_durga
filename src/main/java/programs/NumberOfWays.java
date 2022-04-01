package programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberOfWays {

    //Problem Statement - Consider a game where a player can score 3 0r 5 0r 10 points in a move.
    //Given a total score n, find number of ways to reach the given score.
    //input: n = 20
    //Output: 4
    //There are following four ways to reach
    //(10,10)
    //(5,5,10)
    //(5,5,5,5)
    //(3,3,3,3,3,5)
    public static void main(String[] args) {
        findWays(20);
    }

    public static void findWays(int n){
        int[] arr = new int[n + 1];
        int i =0;

        arr[0] = 1;

        for(i =3; i<=n; i++)
            arr[i] = arr[i] + arr[i-3];
        for(i =5; i<=n; i++)
            arr[i] = arr[i] + arr[i-5];
        for(i =10; i<=n; i++)
            arr[i] = arr[i] + arr[i-10];

        //IntStream.of(arr).mapToObj(Integer::toString).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println(arr[n]);
    }
}
