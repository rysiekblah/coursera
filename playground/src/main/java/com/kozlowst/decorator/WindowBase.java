package com.kozlowst.decorator;

/**
 * Created by tomek on 10/22/14.
 */
public class WindowBase extends Decorator {
    public WindowBase() {
        super(null);
    }

    @Override
    public void draw() {
        System.out.println("BaseDraw");
    }
}
