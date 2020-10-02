package adventofcode2019.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public class Day3 {

    public static void main(String[] args) {

        // get input data
        String filename = "day3input.txt";
        List<String[]> wireDirections = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/adventofcode2019/" + filename))) {
            br.lines().forEach(line -> wireDirections.add(line.split(",")));
        } catch (IOException e) {
            e.printStackTrace();
        }


        // direction
        String[] wire1 = wireDirections.get(0);
        String[] wire2 = wireDirections.get(1);

        Set<Coordinate> route = new HashSet<>(wireDirections.size());
        Coordinate currentCoordinate = new Coordinate();

        for (String instruction : wire1) {
            char direction = instruction.charAt(0);
            int locationToGo = Integer.parseInt(instruction.substring(1));

            for (int step = 0; step < locationToGo; step++) {

                if(direction == 'R') {
                    currentCoordinate = currentCoordinate.getNextCoordinateRight();
                } else if(direction == 'L') {
                    currentCoordinate = currentCoordinate.getNextCoordinateLeft();
                } else if(direction == 'U') {
                    currentCoordinate = currentCoordinate.getNextCoordinateUp();
                } else if(direction == 'D') {
                    currentCoordinate = currentCoordinate.getNextCoordinateDown();
                }
                route.add(currentCoordinate);
        }
    }

        Set<Coordinate> wiresMeeting = new HashSet<>();
        Set<Coordinate> newRoute = new HashSet<>(wireDirections.size());
        currentCoordinate = new Coordinate();

        for (String instruction : wire2) {
            char direction = instruction.charAt(0);
            int locationToGo = Integer.parseInt(instruction.substring(1));


            for (int step = 0; step < locationToGo; step++) {
                if(direction == 'R') {
                    currentCoordinate = currentCoordinate.getNextCoordinateRight();
                } else if(direction == 'L') {
                    currentCoordinate = currentCoordinate.getNextCoordinateLeft();
                } else if(direction == 'U') {
                    currentCoordinate = currentCoordinate.getNextCoordinateUp();
                } else if(direction == 'D') {
                    currentCoordinate = currentCoordinate.getNextCoordinateDown();
                }
                newRoute.add(currentCoordinate);
                if(route.contains(currentCoordinate)) {
                    wiresMeeting.add(currentCoordinate);
                }

            }

        }

        Optional<Coordinate> smallestCoordinate = wiresMeeting.stream()
                        .min(Comparator.comparingInt(Coordinate::getDistanceToOrigin));

        System.out.println(smallestCoordinate);
        System.out.println(smallestCoordinate.get().getDistanceToOrigin());

    }
}

