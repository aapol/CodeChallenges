package adventofcode2019.day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.atomic.AtomicInteger;

public class Day1 {

    public static void main(String[] args)  {

        task1();
        task2();

    }

    private static void task2() {
        String filename = "day1input.txt";

        AtomicInteger sumOfFuel = new AtomicInteger(0);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/adventofcode2019/" + filename));
            bufferedReader.lines()
                    .map(Integer::valueOf)
                    .forEach(mass -> {
                        AtomicInteger rocketsFuel = new AtomicInteger(mass / 3 - 2);
                        while (rocketsFuel.get()>0) {
                            sumOfFuel.addAndGet(rocketsFuel.get());
                            rocketsFuel.getAndSet(rocketsFuel.get()/3-2);
                        } }
                    );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(sumOfFuel.toString());
    }

    private static void task1() {

        AtomicInteger sumOfFuel = new AtomicInteger(0);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/adventofcode2019/day1input.txt"));
            bufferedReader
                    .lines()
                    .map(Integer::valueOf)
                    .forEach(integer -> sumOfFuel.addAndGet(integer / 3 - 2));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(sumOfFuel.toString());
    }
}
