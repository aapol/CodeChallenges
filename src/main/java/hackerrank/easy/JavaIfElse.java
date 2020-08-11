package hackerrank.easy;
import java.util.Scanner;


public class JavaIfElse {

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
