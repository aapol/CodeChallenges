package adventofcode2020.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Builder;

public class Day2 {

    public static void main(String[] args) {
        Stream<String> stringStream = saveInputInList("src/main/java/adventofcode2020/day2/input.txt");

        long countOfValidPassowrds = stringStream
                .map(line -> line.split(" "))
                .filter(data -> isValidPassword(data))
                .count();

        System.out.printf("Count of valid passwords is " + countOfValidPassowrds);
    }

    private static boolean isValidPassword(final String[] data) {
        String[] minAndMaxCount = data[0].split("-");

        int minCount = Integer.valueOf(minAndMaxCount[0]);
        int maxCount = Integer.valueOf(minAndMaxCount[1]);

        char charToLookAt = data[1].charAt(0);

        int charCounter = 0;

        char[] chars = data[2].toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(charToLookAt == chars[i]) {
                charCounter++;
            }
        }

        return charCounter >= minCount && charCounter <= maxCount;
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

@Builder
@AllArgsConstructor
class Password {
    int minCount;
    int maxCount;
    char letterToCount;
    String password;
}
