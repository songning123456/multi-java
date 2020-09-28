package com.sonin.base.decorator;

/**
 * @Author sonin
 * @Date 2020/9/28 6:29 下午
 * @Version 1.0
 **/
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape shape){
        super(shape);
    }

    @Override
    public void draw() {
        decorateShape.draw();
        System.out.println("=ss=");
    }
}
