package com.javaagent.learn;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
        // javassist(inst);
        // byteBuddy(inst);
        jvm();
    }

    private static void javassist(Instrumentation inst) {
        JavassistClassFileTransformer javassistClassFileTransformer = new JavassistClassFileTransformer();
        inst.addTransformer(javassistClassFileTransformer);
    }

    private static void byteBuddy(Instrumentation inst) {
        AgentBuilder.Transformer transformer = (builder, typeDescription, classLoader, javaModule) -> {
            return builder.method(ElementMatchers.any()) // 拦截任意方法
                    .intercept(MethodDelegation.to(ByteBuddyCost.class)); // 委托
        };

        AgentBuilder.Listener listener = new AgentBuilder.Listener() {
            @Override
            public void onDiscovery(String s, ClassLoader classLoader, JavaModule javaModule, boolean b) {
            }

            @Override
            public void onTransformation(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, boolean b, DynamicType dynamicType) {
            }

            @Override
            public void onIgnored(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, boolean b) {
            }

            @Override
            public void onError(String s, ClassLoader classLoader, JavaModule javaModule, boolean b, Throwable throwable) {
            }

            @Override
            public void onComplete(String s, ClassLoader classLoader, JavaModule javaModule, boolean b) {
            }
        };
        new AgentBuilder.Default().type(ElementMatchers.nameStartsWith("com.javaagent.learn")) // 指定需要拦截的类
                .transform(transformer).with(listener).installOn(inst);
    }

    private static void jvm() {
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
            JvmStack.printMemoryInfo();
            JvmStack.printGCInfo();
            System.out.println("===================================================================================================");
        }, 0, 5000, TimeUnit.MILLISECONDS);
    }

    /**
     * 如果代理类没有实现上面的方法，那么JVM将尝试调用该方法
     *
     * @param agentArgs
     */
    public static void premain(String agentArgs) {
    }
}
