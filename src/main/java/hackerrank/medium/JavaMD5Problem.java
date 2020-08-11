package hackerrank.medium;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JavaMD5Problem {


        public static void main(String[] args) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String input = bufferedReader.readLine();
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(input.getBytes());

                byte[] digest = messageDigest.digest();

                for (byte b : digest) {
                    System.out.format("%02x", b);
                }

            } catch (IOException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

}
