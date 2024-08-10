package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Anagram {
    //Program to find if the two strings are Anagrams.
    //Input : listen and silent
    //Output : True
    public static void main (String[] args){

        System.out.println(verifyAnagram("listen","silent"));
        System.out.println(verifyAnagram1("listen","silent"));
    }

    // Function to check if two strings are anagrams using list
    public static boolean verifyAnagram(String a, String b){
        // If the lengths of the strings are not the same, they cannot be anagrams
        if(a.length()!=b.length()) return false;

        // Convert strings to character list and sort it
        List<Character> a1 = a.chars().mapToObj(e -> (char)e).sorted().collect(Collectors.toList());
        List<Character> b1 = b.chars().mapToObj(e -> (char)e).sorted().collect(Collectors.toList());

        //Compare the sorted list
        return a1.equals(b1);
    }

    // Function to check if two strings are anagrams using arrays
    public static boolean verifyAnagram1(String a, String b){
        // If the lengths of the strings are not the same, they cannot be anagrams
        if(a.length()!=b.length()) return false;

        // Convert strings to character arrays
        char[] a1= a.toCharArray();
        char[] b1= b.toCharArray();

        // Sort the character arrays
        Arrays.sort(a1);
        Arrays.sort(b1);

        // Compare the sorted arrays
        return Arrays.equals(a1, b1);
    }
}
