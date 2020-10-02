package adventofcode2019.day3;

import java.util.Objects;

import lombok.Value;

@Value
class CoordinateTaskB {

    int x;
    int y;
    int distanceTraveled;

    public CoordinateTaskB() {
        this.x = 0;
        this.y = 0;
        this.distanceTraveled = 0;
    }

    public CoordinateTaskB getNextCoordinateTo(char direction) {
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

    private CoordinateTaskB getNextCoordinateRight() {
        return new CoordinateTaskB(x + 1, y, distanceTraveled+1);
    }

    private CoordinateTaskB getNextCoordinateLeft() {
        return new CoordinateTaskB(x - 1, y, distanceTraveled+1);
    }

    private CoordinateTaskB getNextCoordinateDown() {
        return new CoordinateTaskB(x, y - 1, distanceTraveled+1);
    }

    private CoordinateTaskB getNextCoordinateUp() {
        return new CoordinateTaskB(x, y + 1, distanceTraveled+1);
    }

    private CoordinateTaskB(final int x, final int y, final int distanceTraveled) {
        this.x = x;
        this.y = y;
        this.distanceTraveled = distanceTraveled;
    }

    int getDistanceToOrigin() {
        return Math.abs(x) + Math.abs(y);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CoordinateTaskB that = (CoordinateTaskB) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
