package com.sonin.base.decorator;

/**
 * @Author sonin
 * @Date 2020/9/28 6:26 下午
 * @Version 1.0
 **/
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("rectangle");
    }
}
