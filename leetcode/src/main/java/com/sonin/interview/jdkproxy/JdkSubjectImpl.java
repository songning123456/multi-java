package com.sonin.interview.jdkproxy;

/**
 * @author sonin
 * @date 2020/7/17 10:48
 */
public class JdkSubjectImpl implements IJdkSubject {
    @Override
    public void jdkProxyMethod(String param) {
        System.out.println("JDK Proxy " + param);
    }
}
