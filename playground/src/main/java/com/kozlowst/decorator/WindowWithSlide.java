package com.kozlowst.decorator;

/**
 * Created by tomek on 10/22/14.
 */
public class WindowWithSlide extends Decorator {
    public WindowWithSlide(Window window) {
        super(window);
    }

    private void drawSlide() {
        System.out.println("WindowWithSlide::drawSlide");
    }

    @Override
    public void draw() {
        super.draw();
        drawSlide();
    }
}
