package fr.xebia.xke.juillet.liskovprinciple;

public class Square extends Rectangle {

    public Square() {
    }

    public Square(int height, int width) {
        super(height, height);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    public int getSide() {
        return getHeight();
    }

    public void setSide(int side) {
        super.setWidth(side);
        super.setHeight(side);
    }
}
