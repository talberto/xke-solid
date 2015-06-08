package fr.xebia.io;

import fr.xebia.controls.MowerControls;
import fr.xebia.model.mower.Mower;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.awt.*;
import java.awt.event.KeyEvent;

@RunWith(MockitoJUnitRunner.class)
public class KeyboardMowerTest {

    private Keyboard keyboard;

    @Mock
    private Mower mower;

    @Before
    public void setUp() throws Exception {
        MowerControls mowerControls = new MowerControls(mower);
        keyboard = new Keyboard(mowerControls);
    }

    @Test
    public void should_advance_on_up_key() {
        // When
        keyboard.keyPressed(mockKeyEvent(KeyEvent.VK_UP));

        // Then
        Mockito.verify(mower).advance();
    }

    @Test
    public void should_turn_right_on_right_key() {
        // When
        keyboard.keyPressed(mockKeyEvent(KeyEvent.VK_RIGHT));

        // Then
        Mockito.verify(mower).turnRight();
    }

    @Test
    public void should_turn_left_on_up_key() {
        // When
        keyboard.keyPressed(mockKeyEvent(KeyEvent.VK_LEFT));

        // Then
        Mockito.verify(mower).turnLeft();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void should_throw_on_down_key() {
        // When
        keyboard.keyPressed(mockKeyEvent(KeyEvent.VK_DOWN));
    }

    private KeyEvent mockKeyEvent(int keyCode) {
        return new KeyEvent(Mockito.mock(Component.class), 0, 0, 0, keyCode, ' ');
    }
}