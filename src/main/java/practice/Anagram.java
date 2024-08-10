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
    }

    public static boolean verifyAnagram(String a, String b){
        if(a.length()!=b.length()) return false;

        List<Character> a1 = a.chars().mapToObj(e -> (char)e).sorted().collect(Collectors.toList());
        List<Character> b1 = b.chars().mapToObj(e -> (char)e).sorted().collect(Collectors.toList());

        return a1.equals(b1);
    }
}
