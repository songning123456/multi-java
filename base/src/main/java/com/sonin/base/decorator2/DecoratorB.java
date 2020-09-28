package com.sonin.base.decorator2;

/**
 * @Author sonin
 * @Date 2020/9/28 7:54 下午
 * @Version 1.0
 **/
public class DecoratorB extends Decorator {

    private AbstractComponent abstractComponent;

    public DecoratorB(AbstractComponent abstractComponent) {
        super(abstractComponent);
        this.abstractComponent = abstractComponent;
    }

    @Override
    public Integer getVal() {
        return this.abstractComponent.getVal() + 2;
    }
}
