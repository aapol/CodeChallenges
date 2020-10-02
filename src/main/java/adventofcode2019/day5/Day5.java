package adventofcode2019.day5;

import java.util.stream.IntStream;

public class Day5 {

    public static void main(String[] args) {

        // range 357253-892942
//        It is a six-digit number.
//        The value is within the range given in your puzzle input.
//        Two adjacent digits are the same (like 22 in 122345).
//        Going from left to right, the digits never decrease; they only ever increase or stay the same (like 111123 or 135679).

// part2:  the two adjacent matching digits are not part of a larger group of matching digits.

        long count = IntStream.range(357253, 892942)
                .filter(password -> twoAdjacentSameDigitsButNoThreeRule(password))
                .filter(password -> digitsNeverDecrease(password))
                .count();

        System.out.println("Count of password combinations: " + count);
    }

    private static boolean twoAdjacentSameDigitsButNoThreeRule(final int password) {
        char[] chars = String.valueOf(password).toCharArray();

        int countOfSameDigitsAdjacent = 0;

        for (int i = 0; i < chars.length - 1; i++) {
            if(chars[i] == chars[i+1]) {
                countOfSameDigitsAdjacent++;
            } else {
                if(countOfSameDigitsAdjacent == 1) {
                    return true;
                } else {
                    countOfSameDigitsAdjacent = 0;
                }
            }
        }
        return countOfSameDigitsAdjacent == 1;
    }

    private static boolean digitsNeverDecrease(final int password) {
        char[] chars = String.valueOf(password).toCharArray();

        for (int i = 0; i < chars.length - 1; i++) {
            if((int) chars[i] > (int) chars[i+1]) {
                return false;
            }
        }
        return true;
    }


}
