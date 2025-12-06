package practice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseWordsPreserveOrder {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();

        Function<String, String> reverseWords = str -> Arrays.stream(str.split(" "))
                .map(word -> IntStream.range(0, word.length())
                        .mapToObj(i -> word.charAt(word.length() -1 -i))
                        .map(String::valueOf)
                        .collect(Collectors.joining()))
                        .collect(Collectors.joining(" "));

        String result = reverseWords.apply(s1);
        System.out.println(result);

        Function<String, String> reverseWordsWithSB = str -> Arrays.stream(str.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
        String result1 = reverseWordsWithSB.apply(s1);
        System.out.println(result1);
    }
}
