package com.sonin.base.decorator2;

/**
 * @Author sonin
 * @Date 2020/9/28 7:55 下午
 * @Version 1.0
 **/
public class Main {

    public static void main(String[] args) {
        AbstractComponent abstractComponent = new ConcreteComponent();
        AbstractComponent abstractComponent1 = new DecoratorA(abstractComponent);
        AbstractComponent abstractComponent2 = new DecoratorB(abstractComponent1);
        System.out.println(abstractComponent2.getVal());
    }
}
