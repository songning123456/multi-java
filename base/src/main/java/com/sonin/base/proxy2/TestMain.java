package com.sonin.base.proxy2;

import java.lang.reflect.Proxy;

/**
 * @Author sonin
 * @Date 2020/9/28 7:08 下午
 * @Version 1.0
 **/
public class TestMain {

    public static void main(String[] args) {
        IBuyHouse iBuyHouse = new BuyHouseImpl();
        IBuyHouse iBuyHouseProxy = (IBuyHouse) Proxy.newProxyInstance(IBuyHouse.class.getClassLoader(), new Class[]{IBuyHouse.class}, new DynamicProxyHandler(iBuyHouse));
        iBuyHouseProxy.buyHouse();
    }
}
