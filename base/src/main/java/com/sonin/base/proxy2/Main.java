package com.sonin.base.proxy2;

/**
 * @Author sonin
 * @Date 2020/9/28 6:57 下午
 * @Version 1.0
 **/
public class Main {

    public static void main(String[] args) {
        IBuyHouse iBuyHouse = new BuyHouseImpl();
        iBuyHouse.buyHouse();
        System.out.println("=====");
        IBuyHouse iBuyHouseProxy = new BuyHouseProxy(iBuyHouse);
        iBuyHouseProxy.buyHouse();
    }
}
