package programs;

import java.util.ArrayList;
import java.util.Arrays;

public class Anagram {

    public static void main(String[] args){

        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(input[0]);
        ArrayList<String> output = new ArrayList<>();
        ArrayList<ArrayList> output1 = new ArrayList<>();

        for(int i=0; i< input.length-1; i++){
            //for(int j=)
            if(isAnagram(input[i],input[i+1])){
                output.add(input[i]);
                output.add(input[i+1]);
            }
        }

        System.out.println();
    }

    public static boolean isAnagram(String a, String b){
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        return Arrays.equals(c1,c2);
    }
}

