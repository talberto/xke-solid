package fr.xebia.xke.solid.ocp;

import static fr.xebia.xke.solid.ocp.Orientation.NORTH;

public class Position {

    final int x;
    final int y;
    final Orientation orientation;

    public Position() {
        this(0, 0, NORTH);
    }

    public Position(int x, int y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }
}
