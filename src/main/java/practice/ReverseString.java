package practice;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Reverse a string and check for palindrome.
public class ReverseString {
    public static void main(String[] args) {
        String s = "level";
        String s1 = new String();
        char[] a = s.toCharArray();

        for(int i=a.length-1; i>=0;i--){
            System.out.print(a[i]);
            s1 = s1 + a[i];
        }

        System.out.println(s.equals(s1));

        System.out.println(IntStream.range(0,s.length())
                .summaryStatistics());

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();

        // Lambda to reverse a string
        Function<String, String> reverse = str -> IntStream.range(0, str.length())
                .mapToObj(i -> str.charAt(str.length() - 1 - i))
                .map(String::valueOf)
                .collect(Collectors.joining());

        // Lambda to check if a string is palindrome
        Predicate<String> isPalindrome = str -> str.equalsIgnoreCase(reverse.apply(str));

        String rev = reverse.apply(input);
        System.out.println(isPalindrome.test(rev));
    }
}
