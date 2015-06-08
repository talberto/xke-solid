package fr.xebia.io;

import fr.xebia.model.mower.Mower;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    Mower mower;

    public Keyboard(Mower mower) {
        this.mower = mower;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                mower.advance();
                break;
            case KeyEvent.VK_RIGHT:
                mower.turnRight();
                break;
            case KeyEvent.VK_DOWN:
                throw new UnsupportedOperationException("Mower can't move backwards !");
            case KeyEvent.VK_LEFT:
                mower.turnLeft();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}