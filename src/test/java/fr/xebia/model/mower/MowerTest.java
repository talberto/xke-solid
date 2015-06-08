package fr.xebia.model.mower;


import org.assertj.core.api.Assertions;
import org.junit.Test;

import static fr.xebia.model.mower.Direction.*;

public class MowerTest {

    @Test
    public void should_advance_in_right_direction() {
        // Given
        Mower mower = new Mower(5, 5, NORTH);

        // When
        mower.advance();

        // Then
        Assertions.assertThat(mower.i).isEqualTo(5);
        Assertions.assertThat(mower.j).isEqualTo(6);
        Assertions.assertThat(mower.direction).isEqualTo(NORTH);
    }

    @Test
    public void should_turn_left() {
        // Given
        Mower mower = new Mower(5, 5, NORTH);

        // When
        mower.turnLeft();

        // Then
        Assertions.assertThat(mower.i).isEqualTo(mower.j).isEqualTo(5);
        Assertions.assertThat(mower.direction).isEqualTo(WEST);
    }

    @Test
    public void should_turn_right() {
        // Given
        Mower mower = new Mower(5, 5, NORTH);

        // When
        mower.turnRight();

        // Then
        Assertions.assertThat(mower.i).isEqualTo(mower.j).isEqualTo(5);
        Assertions.assertThat(mower.direction).isEqualTo(EAST);
    }

    @Test
    public void should_have_right_position_after_path() {
        // Given
        Mower mower1 = new Mower(1, 2, NORTH);
        Mower mower2 = new Mower(3, 3, EAST);

        // When
        mower1.turnLeft();
        mower1.advance();
        mower1.turnLeft();
        mower1.advance();
        mower1.turnLeft();
        mower1.advance();
        mower1.turnLeft();
        mower1.advance();
        mower1.advance();

        mower2.advance();
        mower2.advance();
        mower2.turnRight();
        mower2.advance();
        mower2.advance();
        mower2.turnRight();
        mower2.advance();
        mower2.turnRight();
        mower2.turnRight();
        mower2.advance();

        // Then
        Assertions.assertThat(mower1.i).isEqualTo(1);
        Assertions.assertThat(mower1.j).isEqualTo(3);
        Assertions.assertThat(mower1.direction).isEqualTo(NORTH);

        Assertions.assertThat(mower2.i).isEqualTo(5);
        Assertions.assertThat(mower2.j).isEqualTo(1);
        Assertions.assertThat(mower2.direction).isEqualTo(EAST);
    }
}