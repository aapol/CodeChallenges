package de.idealo.seo.hackerrank;
import java.util.Scanner;


public class JavaIfElse {

//    Task
//    Given an integer, , perform the following conditional actions:
//
//    If  is odd, print Weird
//    If  is even and in the inclusive range of  to , print org.aspectj.weaver.ast.Not Weird
//    If  is even and in the inclusive range of  to , print Weird
//    If  is even and greater than , print Not Weird
//    Complete the stub code provided in your editor to print whether or not  is weird.
//
//            Input Format
//
//    A single line containing a positive integer, .
//
//    Constraints
//
//    Output Format
//
//    Print Weird if the number is weird; otherwise, print Not Weird.
//
//    Sample Input 0
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
            int N = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            if(N > 1 && N < 100) {
                int remainder = N % 2;
                if(remainder == 1) {
                    System.out.println("Weird");
                } else if(N >=2 && N <= 5) {
                    System.out.println("Not Weird");
                } else if (N >= 6 && N <= 20) {
                    System.out.println("Weird");
                } else if (N >= 20) {
                    System.out.println("Not Weird");
                }
        }

            scanner.close();

    }

}
