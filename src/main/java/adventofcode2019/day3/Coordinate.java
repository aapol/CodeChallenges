package adventofcode2019.day3;

import lombok.Value;

@Value
class Coordinate {

    int x;
    int y;
    int distanceTraveled;

    public Coordinate() {
        this.x = 0;
        this.y = 0;
        this.distanceTraveled = 0;
    }

    private Coordinate(final int x, final int y, final int distanceTraveled) {
        this.x = x;
        this.y = y;
        this.distanceTraveled = distanceTraveled;
    }

    public Coordinate getNextCoordinateTo(char direction) {
        switch (direction) {
            case 'R':
                return getNextCoordinateRight();
            case 'L':
                return getNextCoordinateLeft();
            case 'U':
                return getNextCoordinateUp();
            case 'D':
                return getNextCoordinateDown();
        }
        throw new RuntimeException("getNextCoordinate needs a valid direction (U,D,L or R).\n Direction=" + direction + "\nCurrent coordinate=" + this);
    }

    Coordinate getNextCoordinateRight() {
        return new Coordinate(x + 1, y, distanceTraveled+1);
    }

    Coordinate getNextCoordinateLeft() {
        return new Coordinate(x - 1, y, distanceTraveled+1);
    }

    Coordinate getNextCoordinateDown() {
        return new Coordinate(x, y - 1, distanceTraveled+1);
    }

    Coordinate getNextCoordinateUp() {
        return new Coordinate(x, y + 1, distanceTraveled+1);
    }

    int getDistanceToOrigin() {
        return Math.abs(x) + Math.abs(y);
    }
}
