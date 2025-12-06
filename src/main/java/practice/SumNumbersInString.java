package practice;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.function.Function;

public class SumNumbersInString {
    public static void main(String[] args) {
        String s = "abdc112kg45ldy4p9";

        int sum = Pattern.compile("[^0-9]+")
                .splitAsStream(s)
                .filter(str -> !str.isEmpty())
                .mapToInt(num -> {
                    int n = Integer.parseInt(num);
                    return n;
                })
                .sum();

        System.out.println(sum);

        Pattern.compile("[^0-9]+")
                .splitAsStream(s).collect(Collectors.toList()).forEach(System.out::println);

        String a = Pattern.compile("[^0-9]+")
                .splitAsStream(s)
                .filter(str -> !str.isEmpty())
                .mapToInt(Integer::parseInt)
                .summaryStatistics().toString();
        //.getMax();

        System.out.println(a);
    }
}
