package com.sonin.base.proxy2;

/**
 * @Author sonin
 * @Date 2020/9/28 6:56 下午
 * @Version 1.0
 **/
public class BuyHouseProxy implements IBuyHouse {

    private IBuyHouse iBuyHouse;

    public BuyHouseProxy(IBuyHouse iBuyHouse) {
        this.iBuyHouse = iBuyHouse;
    }

    @Override
    public void buyHouse() {
        System.out.println("before");
        iBuyHouse.buyHouse();
        System.out.println("after");
    }
}
