package com.sonin.interview.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author sonin
 * @date 2020/7/17 10:49
 */
public class JdkSubjectProxy implements InvocationHandler {
    private IJdkSubject iJdkSubject;

    public JdkSubjectProxy(IJdkSubject jdkSubject) {
        this.iJdkSubject = jdkSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--------------begin--------------");
        // invoke => 方法的返回值；如果没有，返回null
        Object invoke = method.invoke(iJdkSubject, args);
        System.out.println("--------------end--------------");
        return invoke;
    }
}
