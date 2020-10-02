package adventofcode2019.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Day2 {
    public static void main(String[] args) {

        intcodeTask1();
        intcodeTask2();
    }

    static void intcodeTask2() {

        String filename = "day2input.txt";
        List<Integer> originalInput = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/adventofcode2019/" + filename));
            for (String s : br.readLine().split(",")) {
                originalInput.add(Integer.valueOf(s));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        int result = 0;
        int noun = 0;
        int verb = 0;

        while(result != 19690720) {
            noun = new Random().nextInt(originalInput.size());
            verb = new Random().nextInt(originalInput.size());

            List<Integer> testInput = new ArrayList<>(originalInput.size());
            testInput.addAll(originalInput);

            result = calculateProgramOutput(testInput, noun, verb);
        }
        System.out.println("noun: " + noun + " verb: " + verb + " result= " + result);
        System.out.println(originalInput.get(0));
    }

    private static int calculateProgramOutput(final List<Integer> input, int noun, int verb) {
        input.set(1, noun);
        input.set(2, verb);

        int instructionPointer = 0;

        for (int i = 0; i < input.size(); i=instructionPointer) {
            int opcode = input.get(i);
            int result = 0;
            int number1 = input.get(input.get(i+1));
            int number2 = input.get(input.get(i+2));
            int locationToEdit = input.get(i+3);

            if(opcode == 1) {
                result = number1 + number2;
            } else if (opcode == 2) {
                result = number1 * number2;
            } else if (opcode == 99) {
                break;
            }
            instructionPointer += 4;
            input.set(locationToEdit, result);
        }
        return input.get(0);
    }


    static void intcodeTask1() {

        String filename = "day2input.txt";
        ArrayList<Integer> input = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/adventofcode2019/" + filename));
            for (String s : br.readLine().split(",")) {
                input.add(Integer.valueOf(s));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

            input.set(1, 12);
            input.set(2, 2);


            for (int i = 0; i < input.size(); i=i+4) {
                int opcode = input.get(i);
                int result = 0;
                int number1 = input.get(input.get(i+1));
                int number2 = input.get(input.get(i+2));
                int locationToEdit = input.get(i+3);

                if(opcode == 1) {
                    result = number1 + number2;
                } else if (opcode == 2) {
                    result = number1 * number2;
                } else if (opcode == 99) {
                    break;
                }
                input.set(locationToEdit, result);
            }

            System.out.println(input.get(0));



    }

    // 4 numbers
    // 1: 1 adds, 2 multiplies, 99 stop programm
    // 2,3: numbers to calculate
    // 4: which cell save the answer
}
