package com.sonin.base.decorator;

/**
 * @Author sonin
 * @Date 2020/9/28 6:31 下午
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle();
        ShapeDecorator redCircle = new RedShapeDecorator(circle);
        redCircle.draw();
    }
}
