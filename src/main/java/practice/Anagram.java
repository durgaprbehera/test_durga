package practice;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class Anagram {
    //Program to find if the two strings are Anagrams.
    //Input : listen and silent
    //Output : True
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:: ");
        String str1 = scanner.nextLine();
        System.out.println("Enter a string:: ");
        String str2 = scanner.nextLine();
        scanner.close();

        System.out.println(verifyAnagram(str1, str2));
        System.out.println(verifyAnagram1("listen", "silent"));

        BiPredicate<String, String> areAnagrams = (s1, s2) -> {
            List<Character> list1 = s1.chars().mapToObj(e -> (char) e).sorted().collect(Collectors.toList());
            List<Character> list2 = s2.chars().mapToObj(e -> (char) e).sorted().collect(Collectors.toList());

            return list1.equals(list2);
        };

        System.out.println(areAnagrams.test(str1, str2));
    }

    // Function to check if two strings are anagrams using list
    public static boolean verifyAnagram(String a, String b) {
        // If the lengths of the strings are not the same, they cannot be anagrams
        if (a.length() != b.length()) return false;

        // Convert strings to character list and sort it
        List<Character> a1 = a.chars().mapToObj(e -> (char) e).sorted().collect(Collectors.toList());
        List<Character> b1 = b.chars().mapToObj(e -> (char) e).sorted().collect(Collectors.toList());

        //Compare the sorted list
        return a1.equals(b1);
    }

    // Function to check if two strings are anagrams using arrays
    public static boolean verifyAnagram1(String a, String b) {
        // If the lengths of the strings are not the same, they cannot be anagrams
        if (a.length() != b.length()) return false;

        // Convert strings to character arrays
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();

        // Sort the character arrays
        Arrays.sort(a1);
        Arrays.sort(b1);

        // Compare the sorted arrays
        return Arrays.equals(a1, b1);
    }
}
