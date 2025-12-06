package programs.zenoti;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PrintOccurrences {

    public static void main(String[] args){
        String a = "Occurrences";
        printOcc(a);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();

        Function<String, Map<Character, Long>> charFrequency = str -> str.chars()
                .mapToObj(e -> (char)e)
                .filter(s -> !Character.isWhitespace(s))
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new,Collectors.counting()));

       Map<Character, Long> m = charFrequency.apply(input);

       m.forEach((k,v) -> System.out.println(k + " "+ v));
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
