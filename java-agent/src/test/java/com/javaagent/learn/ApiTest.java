package com.javaagent.learn;

/**
 * @author sonin
 * @date 2021/1/11 14:40
 */
public class ApiTest {

    public static void main(String[] args) {
        ApiTest apiTest = new ApiTest();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        apiTest.echoHi();
    }

    private void echoHi() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("hi agent");
    }
}
