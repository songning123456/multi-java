package com.javaagent.learn;

import java.lang.instrument.Instrumentation;

/**
 * @author sonin
 * @date 2021/1/11 11:16
 */
public class MyAgent {

    /**
     * JVM首先尝试在代理类上调用以下方法
     *
     * @param agentArgs
     * @param inst
     */
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("agent params：" + agentArgs);
        JavassistClassFileTransformer javassistClassFileTransformer = new JavassistClassFileTransformer();
        inst.addTransformer(javassistClassFileTransformer);
    }

    /**
     * 如果代理类没有实现上面的方法，那么JVM将尝试调用该方法
     *
     * @param agentArgs
     */
    public static void premain(String agentArgs) {
    }
}
