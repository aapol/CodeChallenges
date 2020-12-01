package adventofcode2020.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 {

    public static void main(String[] args) {

        List<Integer> input = saveInputInList("src/main/java/adventofcode2020/day1/input.txt");

        int result = findIntegersForBookkeeper(input);

        System.out.println("Result is: " + result);
    }

    private static int findIntegersForBookkeeper(final List<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            Integer firstEntry = input.get(i);
            for (int j = i + 1; j < input.size() - 1; j++) {
                Integer secondEntry = input.get(j);
                if(firstEntry + secondEntry == 2020) {
                    return firstEntry * secondEntry;
                }
            }
        }
        return -1;
    }

    private static List<Integer> saveInputInList(final String filePath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            return br.lines().mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
