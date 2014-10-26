package com.kozlowst.decorator;

/**
 * Created by tomek on 10/22/14.
 */
public class Test {
    public static void main(String[] args) {
        Decorator decorator = new WindowWithFrames(new WindowWithSlide(new WindowBase()));
        decorator.draw();
    }
}
