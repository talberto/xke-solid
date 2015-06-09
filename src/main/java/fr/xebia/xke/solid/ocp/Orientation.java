package fr.xebia.xke.solid.ocp;

public enum Orientation {
    NORTH(90, 0, 1),
    EAST(0, 1, 0),
    SOUTH(270, 0, -1),
    WEST(180, -1, 0);

    public static final int DEFAULT_ANGLE = 90;

    private final int angle;
    public final int plusX;
    public final int plusY;

    private Orientation(int angle, int plusX, int plusY) {
        this.angle = angle;
        this.plusX = plusX;
        this.plusY = plusY;
    }

    public Orientation turn(int angle) {
        int newAngle = (this.angle + angle) % 360;
        return Orientation.fromAngle(newAngle);
    }

    private static Orientation fromAngle(int angle) {
        for (Orientation orientation : values()) {
            if (angle == orientation.angle) {
                return orientation;
            }
        }
        throw new IllegalArgumentException("Invalid angle: " + angle);
    }
}
