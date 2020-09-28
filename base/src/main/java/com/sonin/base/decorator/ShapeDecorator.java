package com.sonin.base.decorator;

/**
 * @Author sonin
 * @Date 2020/9/28 6:28 下午
 * @Version 1.0
 **/
public abstract class ShapeDecorator implements Shape {

    public Shape decorateShape;

    public ShapeDecorator(Shape shape) {
        this.decorateShape = shape;
    }

    @Override
    public void draw() {
        decorateShape.draw();
    }
}
