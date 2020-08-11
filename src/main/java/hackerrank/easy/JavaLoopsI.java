// https://www.hackerrank.com/challenges/java-loops-i/problem
package hackerrank.easy;

import java.util.Scanner;

public class JavaLoopsI {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for(int i=1; i<=10; i++){
            System.out.println(N + " x " + i + " = " + i*N);
        }
        scanner.close();
        }
}
