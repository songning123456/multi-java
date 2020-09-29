package com.sonin.base.builder;

/**
 * @Author sonin
 * @Date 2020/9/29 6:42 下午
 * @Version 1.0
 **/
public class Main {

    public static void main(String[] args) {
        Computer computer = new Computer.Builder().cpu("cpu").screen("screen").memory("memory").builder();
        System.out.println(computer);
    }
}
