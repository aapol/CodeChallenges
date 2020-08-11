// https://www.hackerrank.com/challenges/java-loops/problem
package hackerrank.easy;

import java.util.Scanner;

public class JavaLoopsII {
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            for (int j = 0; j < n; j++) {
                int result = a;
                for (int k = 0; k <= j; k++) {
                    result += Math.pow(2,k) * b;
                }
                System.out.print(result + " ");
            }
            System.out.printf("%n");
        }
        in.close();
    }
}
