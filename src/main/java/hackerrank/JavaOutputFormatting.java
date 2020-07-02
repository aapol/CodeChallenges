package de.idealo.seo.hackerrank;

import java.util.Scanner;

public class JavaOutputFormatting {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++){
            String s1=sc.next();
            int x=sc.nextInt();
            for (int j = 0; j >= (14-s1.length()); j++) {
                s1 = s1 + " ";
            }
            if(x<=9) {
                s1 += "00" + x;
            } else if(x<=99) {
                s1 += "0" +x;
            } else {
                s1 += String.valueOf(x);
            }
            System.out.println(s1);
        }
        System.out.println("================================");

    }

}
