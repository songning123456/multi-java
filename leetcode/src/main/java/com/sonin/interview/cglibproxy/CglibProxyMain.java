package com.sonin.interview.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author sonin
 * @date 2020/7/17 11:24
 */
public class CglibProxyMain {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibSubject.class);
        enhancer.setCallback(new CglibInterceptor());
        CglibSubject cglibSubject = (CglibSubject) enhancer.create();
        cglibSubject.cglibProxyMethod();
    }
}
