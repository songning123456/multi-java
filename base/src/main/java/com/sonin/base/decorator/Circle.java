package com.sonin.base.decorator;

/**
 * @Author sonin
 * @Date 2020/9/28 6:27 下午
 * @Version 1.0
 **/
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("circle");
    }
}
