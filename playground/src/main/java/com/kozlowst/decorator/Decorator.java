package com.kozlowst.decorator;

/**
 * Created by tomek on 10/22/14.
 */

public class Decorator implements Window {

    private Window window;

    public Decorator(Window window) {
        this.window = window;
    }

    @Override
    public void draw() {
        System.out.println("Decorator::draw");
        window.draw();
    }

    @Override
    public void changeSize() {
        window.changeSize();
    }
}
