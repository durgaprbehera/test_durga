package programs;

import java.util.stream.IntStream;

public class CDKSample1 {

    public static void main(String[] args){
        print(100);
    }

    public static void print(int num){
        IntStream.range(1,num).forEach(i -> {
            if(i%3==0 && i%5==0) {
                System.out.println("CDK GLOBAL");
            }
            else if(i%3==0){
                System.out.println("CDK");
            }
            else if(i%5==0){
                System.out.println("GLOBAL");
            }
            else
                System.out.println(i);
        });
    }
}
