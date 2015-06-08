package fr.xebia.model.mower;

public class Mower {
    int i;
    int j;
    Direction direction;

    public Mower(int i, int j, Direction direction) {
        this.i = i;
        this.j = j;
        this.direction = direction;
    }

    public void advance() {
        switch (direction) {
            case NORTH:
                this.j++;
                break;
            case EAST:
                this.i++;
                break;
            case SOUTH:
                this.j--;
                break;
            case WEST:
                this.i--;
                break;
        }
    }

    public void turnRight() {
        relativeTurn(1);
    }

    public void turnLeft() {
        relativeTurn(-1);
    }

    private void relativeTurn(int rotation) {
        int length = Direction.values().length;
        int relativeIndex = (this.direction.ordinal() + rotation + length) % length;
        this.direction = Direction.values()[relativeIndex];
    }

}
