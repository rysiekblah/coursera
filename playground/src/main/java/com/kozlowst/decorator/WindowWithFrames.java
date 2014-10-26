package com.kozlowst.decorator;

/**
 * Created by tomek on 10/22/14.
 */
public class WindowWithFrames extends Decorator {
    public WindowWithFrames(Window window) {
        super(window);
    }

    private void drawFrame() {
        System.out.println("WindowWithFrames:drawFrame");
    }

    @Override
    public void draw() {
        super.draw();
        drawFrame();
    }
}
