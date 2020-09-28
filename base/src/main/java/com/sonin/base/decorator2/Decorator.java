package com.sonin.base.decorator2;

/**
 * @Author sonin
 * @Date 2020/9/28 7:50 下午
 * @Version 1.0
 **/
public abstract class Decorator extends AbstractComponent {

    private AbstractComponent abstractComponent;

    public Decorator(AbstractComponent abstractComponent) {
        this.abstractComponent = abstractComponent;
    }

    @Override
    public Integer getVal() {
        return this.abstractComponent.getVal();
    }
}
