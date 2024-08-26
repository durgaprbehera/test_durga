package hackerrank;

import java.util.*;
import java.math.BigInteger;

//https://www.hackerrank.com/challenges/java-datatypes/problem

public class Java8PrimitiveDataType {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        // Iterate through each test case
        for (int i = 0; i < t; i++) {
            try {
                // Read the next input as long
                long x=scanner.nextLong();
                // Convert the input to BigInteger
                BigInteger n = BigInteger.valueOf(x);


                // Check and print which data types the number can fit in
                System.out.println(n + " can be fitted in:");
                if (n.compareTo(BigInteger.valueOf(Byte.MIN_VALUE)) >= 0 && n.compareTo(BigInteger.valueOf(Byte.MAX_VALUE)) <= 0) {
                    System.out.println("* byte");
                }
                if (n.compareTo(BigInteger.valueOf(Short.MIN_VALUE)) >= 0 && n.compareTo(BigInteger.valueOf(Short.MAX_VALUE)) <= 0) {
                    System.out.println("* short");
                }
                if (n.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) >= 0 && n.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) <= 0) {
                    System.out.println("* int");
                }
                if (n.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) >= 0 && n.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) <= 0) {
                    System.out.println("* long");
                }
            } catch (Exception e) {
                // If an exception is thrown, the number can't be fitted anywhere
                System.out.println(scanner.next() + " can't be fitted anywhere.");
            }
        }
    }

}