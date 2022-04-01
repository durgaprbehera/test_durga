package programs.zenoti;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PrintOccurrences {

    public static void main(String[] args){
        String a = "Occurrences";
        printOcc(a);
    }

    private static void printOcc(String str){
        LinkedHashMap<Character, Integer> map = new LinkedHashMap();
        List<Character> characterList = str.chars().mapToObj(i -> (char)i).collect(Collectors.toList());

        for(int i=0; i<characterList.size(); i++){
            map.put(characterList.get(i), map.getOrDefault(characterList.get(i),0)+1);
        }

        map.forEach((k,v)-> System.out.print(k+""+v));

    }
}
