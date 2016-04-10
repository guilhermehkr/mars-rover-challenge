package mars.compass;

import mars.model.Coordinate;

import java.util.Arrays;

public enum Compass {

    East("E") {
        @Override
        public Coordinate move(final Coordinate coordinate) {
            return new Coordinate(coordinate.getX() + 1, coordinate.getY());
        }
    },
    West("W") {
        @Override
        public Coordinate move(final Coordinate coordinate) {
            return new Coordinate(coordinate.getX() - 1, coordinate.getY());
        }
    },
    North("N") {
        @Override
        public Coordinate move(final Coordinate coordinate) {
            return new Coordinate(coordinate.getX(), coordinate.getY() + 1);
        }
    },
    South("S") {
        @Override
        public Coordinate move(final Coordinate coordinate) {
            return new Coordinate(coordinate.getX(), coordinate.getY() - 1);
        }
    },
    Unknown("U") {
        @Override
        public Coordinate move(final Coordinate coordinate) {
            throw new UnsupportedOperationException("Unknown direction doesn't move");
        }
    };

    private String symbol;
    Compass(String symbol) {
        this.symbol = symbol;
    }

    public abstract Coordinate move(final Coordinate coordinate);

    public static Compass from(String compass) {
        return Arrays.stream(Compass.values())
                .filter(option -> option.getSymbol().equalsIgnoreCase(compass))
                .findFirst()
                .orElse(Unknown);
    }

    public String getSymbol() {
        return symbol;
    }
}
