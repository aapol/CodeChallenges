package adventofcode2019.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day5 {
    public static void main(String[] args) {

        // parameter modes
        // 0 position mode
        // 1 immediate mode
        //
        // opcodes:
        // 1 adds numbers 2,3 to 4
        // 2 multiplies numbers 2,3 to 4
        // 3 saves input to 2
        // 4 outputs number 2
        // 99 stops programm
        // 2,3: numbers to calculate
        // 4: which cell save the answer


        List<Integer> originalInput = saveInputInList("src/main/java/adventofcode2019/day5/input.txt");

        intcodeTaskDay5(originalInput, 1);

    }

    private static List<Integer> saveInputInList(final String filePath) {
        List<Integer> originalInput = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            for (String s : br.readLine().split(",")) {
                originalInput.add(Integer.valueOf(s));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return originalInput;
    }

    static void intcodeTaskDay5(List<Integer> originalInput, int initialTaskInput) {

        originalInput.set(1, 12);
        originalInput.set(2, 2);


        for (int i = 0; i < originalInput.size();) {
            String RAWopcodeAndParameterMode = String.valueOf(originalInput.get(i));
            log.warn("i = " + i);
            log.warn("opcode and parameters = " + RAWopcodeAndParameterMode);

            String opcode = getOpcode(RAWopcodeAndParameterMode);
            Map<Integer, Integer> parameterModeParameters = getParameterMode(RAWopcodeAndParameterMode);

            try {
                i = handleInstruction(opcode, parameterModeParameters, originalInput, initialTaskInput, i);
            } catch (Opcode99Exception e) {
                i = originalInput.size();
                endProgramAndPrintOutput(originalInput);
            }
        }
    }

    private static void endProgramAndPrintOutput(final List<Integer> originalInput) {
        System.out.println(originalInput.get(0));
    }

    private static int handleInstruction(String opcode, Map<Integer, Integer> parameterModeParameters, List<Integer> originalInput, int initialTaskInput, int originalInputLocation) throws Opcode99Exception {

        int locationToEdit = getParameter(1, parameterModeParameters, originalInputLocation, originalInput);
        int parameter1 = getParameter(2, parameterModeParameters, originalInputLocation, originalInput);
        int parameter2 = getParameter(3, parameterModeParameters, originalInputLocation, originalInput);

        switch (opcode) {
            case "1":
                originalInput.set(locationToEdit, parameter1 + parameter2);
                return originalInputLocation + 4;
            case "2":
                originalInput.set(locationToEdit, parameter1 * parameter2);
                return originalInputLocation + 4;
            case "3":
                originalInput.set(originalInput.get(parameter1), initialTaskInput);
                return originalInputLocation + 2;
            case "4":
                System.out.println(originalInput.get(parameter1));
                return originalInputLocation + 2;
            case "99":
                throw new Opcode99Exception("opcode: 99 ends program");
            default:
                log.warn("invalid opcode:{}", opcode);
                throw new RuntimeException("invalid ocpode");
        }
    }

    public static Integer getParameter(int paramaterNumber, Map<Integer, Integer> parameterModeParameters,int originalInputLocation, List<Integer> originalInput) {
        if(parameterModeParameters.getOrDefault(paramaterNumber, 0) == 0) {
            return originalInput.get(originalInput.get(originalInputLocation+paramaterNumber));
        } else {
            return originalInput.get(originalInputLocation+paramaterNumber);
        }
    }

    public static Map<Integer, Integer> getParameterMode(final String opcodeAndParameterMode) {

        Map<Integer, Integer> parameterModeParameters = new HashMap<>();
        if(opcodeAndParameterMode.length() <= 2) return parameterModeParameters;

        CharSequence parametersInOrder = new StringBuilder(opcodeAndParameterMode).reverse().subSequence(2, opcodeAndParameterMode.length());
        log.warn("parameters as charSequence: {}", parametersInOrder);
        for (int i = 0; i < parametersInOrder.length(); i++) {

            parameterModeParameters.put(i+1, (int) parametersInOrder.charAt(i));
        }

        return parameterModeParameters;
    }

    static String getOpcode(final String opcodeAndParameterMode) {
        if(opcodeAndParameterMode.length() == 1) {
            return opcodeAndParameterMode;
        }

        String opcode = opcodeAndParameterMode.substring(opcodeAndParameterMode.length() - 2);
        if(opcode.substring(0,0).equals("0")) {
            return opcode.substring(1);
        } else return opcode;
    }


    static void intcodeTask2(List<Integer> originalInput) {

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
        endProgramAndPrintOutput(originalInput);
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

    static class Opcode99Exception extends Exception {
        public Opcode99Exception(final String message) {
            super(message);
        }
    }
}
