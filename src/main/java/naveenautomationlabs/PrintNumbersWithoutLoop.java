package naveenautomationlabs;

import java.util.stream.IntStream;

public class PrintNumbersWithoutLoop {
    public static void main(String[] args){
        /**
         * Print 1 to 100 Without Using for/while/do-while Loop in Code || Using Recursive
         */
        printNum(1);

        IntStream.range(1,101).forEach(System.out::println);
    }
    public static void printNum(int num){
        if(num <= 100){
            System.out.println(num);
            num++;
            printNum(num);
        }
    }
}
