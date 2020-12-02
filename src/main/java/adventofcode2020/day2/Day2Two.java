package adventofcode2020.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class Day2Two {

    public static void main(String[] args) {
        Stream<String> stringStream = saveInputInList("src/main/java/adventofcode2020/day2/input.txt");

        long countOfValidPassowrds = stringStream
                .map(line -> line.split(" "))
                .filter(data -> isValidPassword(data))
                .count();

        System.out.printf("Count of valid passwords is " + countOfValidPassowrds);
    }

    private static boolean isValidPassword(final String[] data) {
        String[] firstAndSecondLocation = data[0].split("-");
        int firstLocation = Integer.valueOf(firstAndSecondLocation[0]) -1;
        int secondLocation = Integer.valueOf(firstAndSecondLocation[1]) -1;
        char charToSearch = data[1].charAt(0);
        char[] chars = data[2].toCharArray();

        return (charToSearch == chars[firstLocation]) == (charToSearch != chars[secondLocation]);
    }

    private static Stream<String> saveInputInList(final String filePath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            return br.lines();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Stream.empty();
    }
}

