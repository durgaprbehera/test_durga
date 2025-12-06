package practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingChar {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word::");
        String s = scanner.nextLine();
        scanner.close();

        Function<String, Character> nonRepChar = str -> str.chars()
                .mapToObj(e -> (char)e)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry-> entry.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println(nonRepChar.apply(s));

        Character result = nonRepChar.apply(s);

        if (result != null) {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}
