package fr.xebia.xke.solid.ocp;

import static fr.xebia.xke.solid.ocp.Orientation.DEFAULT_ANGLE;

public enum Command {
    A {
        @Override
        public Position apply(Position currentPosition) {
            return new Position(currentPosition.x + currentPosition.orientation.plusX,
                                currentPosition.y + currentPosition.orientation.plusY,
                                currentPosition.orientation
                    );
        }
    },
    G {
        @Override
        public Position apply(Position currentPosition) {
            return new Position(currentPosition.x, currentPosition.y, currentPosition.orientation.turn(DEFAULT_ANGLE));
        }
    },
    D {
        @Override
        public Position apply(Position currentPosition) {
            return new Position(currentPosition.x, currentPosition.y, currentPosition.orientation.turn(-DEFAULT_ANGLE));
        }
    };

    private Command() { }

    public abstract Position apply(Position currentPosition);

}
