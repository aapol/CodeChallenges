package adventofcode2019.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import lombok.Value;

public class Day3TaskB {

    public static void main(String[] args) {

        // get input data
        String filename = "day3input.txt";
        List<String[]> wireDirections = readDirectionsForTwoWires(filename);

        // directions
        String[] wire1 = wireDirections.get(0);
        String[] wire2 = wireDirections.get(1);

        List<CoordinateTaskB> wire1Route = calculateRouteForWire(wire1);
        List<CoordinateTaskB> wire2Route = calculateRouteForWire(wire2);

        int combinedDistanceTraveled = wire1Route.stream()
                .filter(coordinate -> wire2Route.contains(coordinate))
                .map(coordinateTaskB -> new AbstractMap.SimpleImmutableEntry<>(coordinateTaskB,
                        wire2Route.stream().filter(secondCoordinate -> secondCoordinate.equals(coordinateTaskB)).findFirst().get()))
                .peek(entry -> System.out.println(entry))
                .mapToInt(mapEntry -> (mapEntry.getKey().getDistanceTraveled() + mapEntry.getValue().getDistanceTraveled()))
                .min().orElseGet(null);

        System.out.println("Smalles combined distance traveled: " + combinedDistanceTraveled);

    }

    private static List<CoordinateTaskB> calculateRouteForWire(String[] wireDirections) {
        List<CoordinateTaskB> wireRoute = new ArrayList<>();

        for (String instruction : wireDirections) {
            CoordinateTaskB lastCoordinate = getLastCoordinateOrCentralCoordinate(wireRoute);
            wireRoute.addAll(getInstructionInCoordinates(instruction, lastCoordinate));
        }

        return wireRoute;
    }

    private static CoordinateTaskB getLastCoordinateOrCentralCoordinate(List<CoordinateTaskB> wireRoute) {
        if(wireRoute == null || wireRoute.size() == 0) {
            return new CoordinateTaskB();
        } else {
            return wireRoute.get(wireRoute.size()-1);
        }
    }

    private static List<CoordinateTaskB> getInstructionInCoordinates(final String instruction, CoordinateTaskB lastCoordinate) {

        CoordinateInstruction coordinateInstruction = new CoordinateInstruction(instruction.charAt(0), Integer.parseInt(instruction.substring(1)));

        List<CoordinateTaskB> instructions = new ArrayList<>(coordinateInstruction.getDistanceToGoTo());

        for (int step = 0; step < coordinateInstruction.getDistanceToGoTo(); step++) {
            lastCoordinate = lastCoordinate.getNextCoordinateTo(coordinateInstruction.getDirection());
            instructions.add(lastCoordinate);
        }
        return instructions;
    }

    private static List<String[]> readDirectionsForTwoWires(final String filename) {
        List<String[]> wireDirections = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/adventofcode2019/" + filename))) {
            br.lines().forEach(line -> wireDirections.add(line.split(",")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wireDirections;
    }
}

@Value
class CoordinateInstruction {
    char direction;
    int distanceToGoTo;
}
