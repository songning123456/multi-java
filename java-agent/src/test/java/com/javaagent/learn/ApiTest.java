package com.javaagent.learn;

/**
 * @author sonin
 * @date 2021/1/11 14:40
 */
public class ApiTest {

    public static void main(String[] args) {
        ApiTest apiTest = new ApiTest();
        apiTest.echoHi();
    }

    private void echoHi() {
        System.out.println("hi agent");
    }
}
