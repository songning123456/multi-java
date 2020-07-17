package com.sonin.interview.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author sonin
 * @date 2020/7/17 10:52
 */
public class JdkProxyMain {
    public static void main(String[] args) {
        IJdkSubject iJdkSubject = new JdkSubjectImpl();
        InvocationHandler jdkSubjectProxy = new JdkSubjectProxy(iJdkSubject);
        // jdkSubjectProxy.getClass().getClassLoader() => 代理类的类加载器
        // iJdkSubject.getClass().getInterfaces() => 被代理类的接口，如果有多个就是数组的形式传入
        // jdkSubjectProxy => 代理类实例
        IJdkSubject proxyInstance = (IJdkSubject) Proxy.newProxyInstance(jdkSubjectProxy.getClass().getClassLoader(), iJdkSubject.getClass().getInterfaces(), jdkSubjectProxy);
        proxyInstance.jdkProxyMethod("success");
    }
}
