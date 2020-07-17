package com.sonin.interview.cglibproxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author sonin
 * @date 2020/7/17 11:19
 */
public class CglibInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("--------------begin--------------");
        // MethodProxy => 代理方法
        // object => 被代理对象的实例
        // invokeSuper => 调用被拦截的方法，不要使用invoke，会出现OOM的情况
        Object obj = methodProxy.invokeSuper(object, objects);
        System.out.println("--------------end--------------");
        return obj;
    }
}
