package com.sonin.base.proxy2;

import com.sun.deploy.net.proxy.DynamicProxyManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author sonin
 * @Date 2020/9/28 7:04 下午
 * @Version 1.0
 **/
public class DynamicProxyHandler implements InvocationHandler {

    private Object object;

    public DynamicProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        System.out.println("before");
        Object result = method.invoke(object, args);
        System.out.println("after");
        return result;
    }
}
