package com.sonin.base.proxy;

/**
 * @Author sonin
 * @Date 2020/9/24 2:49 下午
 * @Version 1.0
 **/
public class BuyHouseProxy implements BuyHouse {

    private BuyHouse buyHouse;

    public BuyHouseProxy(final BuyHouse buyHouse) {
        this.buyHouse = buyHouse;
    }

    @Override
    public void buyHouse () {
        System.out.println("before");
        buyHouse.buyHouse();
        System.out.println("after");
    }
}
