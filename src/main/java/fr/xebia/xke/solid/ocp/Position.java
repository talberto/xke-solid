package fr.xebia.xke.solid.ocp;

public class Position {

    final int x;
    final int y;

    public Position() {
        this(0, 0);
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
