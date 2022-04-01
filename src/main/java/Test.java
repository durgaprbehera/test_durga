import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args){
        System.out.println("Hello World");
        ArrayList<String> list = new ArrayList<>();
        list.add("Hi");
        list.forEach(System.out::println);
    }
}
