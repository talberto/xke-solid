package fr.xebia.io;

import fr.xebia.controls.ControlsService;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    private ControlsService controlsService;

    public Keyboard(ControlsService controlsService) {
        this.controlsService = controlsService;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                controlsService.up();
                break;
            case KeyEvent.VK_RIGHT:
                controlsService.right();
                break;
            case KeyEvent.VK_DOWN:
                controlsService.down();
            case KeyEvent.VK_LEFT:
                controlsService.left();
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