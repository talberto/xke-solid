package fr.xebia.xke.juillet.liskovprinciple;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestLiskovPrinciple {

    @Test
    public void testRectangleInvariance() {
        Rectangle rectangle = new Rectangle();

        rectangle.setHeight(10);
        rectangle.setWidth(15);

        assertThat(rectangle.getHeight()).isEqualTo(10);
        assertThat(rectangle.getWidth()).isEqualTo(15);
    }

    @Test
    public void testSquareInvariance() {
        Rectangle rectangle = new Square();

        rectangle.setHeight(10);
        rectangle.setWidth(15);

        assertThat(rectangle.getHeight()).isEqualTo(10);
        assertThat(rectangle.getWidth()).isEqualTo(15);
    }
}
