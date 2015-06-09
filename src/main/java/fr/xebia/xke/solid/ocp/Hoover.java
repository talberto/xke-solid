package fr.xebia.xke.solid.ocp;

import static fr.xebia.xke.solid.ocp.Orientation.EAST;
import static fr.xebia.xke.solid.ocp.Orientation.NORTH;
import static fr.xebia.xke.solid.ocp.Orientation.SOUTH;
import static fr.xebia.xke.solid.ocp.Orientation.WEST;

public class Hoover {

    private final String program;
    private Position currentPosition = new Position();
    private Orientation currentOrientation = Orientation.NORTH;

    public Hoover(String program) {
        this.program = program;
    }

    public void clean() {
        for (int i = 0 ; i < program.length() ; i++) {
            switch (program.charAt(i)) {
                case('A'):
                    goForward();
                    break;
                case('D'):
                    turnRight();
                    break;
                case('G'):
                    turnLeft();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid command: " + program.charAt(i));
            }
        }
    }

    private void turnLeft() {
        switch(currentOrientation) {
            case NORTH:
                currentOrientation = WEST;
                break;
            case WEST:
                currentOrientation = SOUTH;
                break;
            case SOUTH:
                currentOrientation = EAST;
                break;
            case EAST:
                currentOrientation = NORTH;
                break;
            default:
                throw new IllegalArgumentException("Invalid orientation: " + currentOrientation.name());
        }
    }

    private void turnRight() {
        switch(currentOrientation) {
            case NORTH:
                currentOrientation = EAST;
                break;
            case EAST:
                currentOrientation = SOUTH;
                break;
            case SOUTH:
                currentOrientation = WEST;
                break;
            case WEST:
                currentOrientation = NORTH;
                break;
            default:
                throw new IllegalArgumentException("Invalid orientation: " + currentOrientation.name());
        }
    }

    private void goForward() {
        switch(currentOrientation) {
            case NORTH:
                currentPosition = new Position(currentPosition.x, currentPosition.y + 1);
                break;
            case EAST:
                currentPosition = new Position(currentPosition.x + 1, currentPosition.y);
                break;
            case SOUTH:
                currentPosition = new Position(currentPosition.x, currentPosition.y - 1);
                break;
            case WEST:
                currentPosition = new Position(currentPosition.x - 1, currentPosition.y);
                break;
            default:
                throw new IllegalArgumentException("Invalid orientation: " + currentOrientation.name());
        }
    }

    public Position getPosition() {
        return currentPosition;
    }
}
