// https://www.hackerrank.com/challenges/java-datatypes/problem
package hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

public class JavaEndOfFile {
    public static void main(String []args)
    {
        ArrayList<String> file = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
         file.add(sc.nextLine());
        }
        int lineNumber = 0;
        for (String line: file) {
            lineNumber++;
            System.out.println(lineNumber + " " + line);
        }
        
    }
}

