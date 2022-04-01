package practice;

import java.util.stream.IntStream;

public class CDKSample1 {
    public static void main(String[] args){
        print(100);
    }

    public static void print(int n){
        IntStream.range(1,n).forEach( i -> {
                    if( i%3==0 && i%5==0)
                        System.out.println("CDK Global");
                    else if(i%3==0)
                        System.out.println("CDK");
                    else if (i%5==0)
                        System.out.println("Global");
                    else System.out.println(i);
        }
        );
    }
}
