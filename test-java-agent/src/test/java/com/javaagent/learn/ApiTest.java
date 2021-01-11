package com.javaagent.learn;

/**
 * @author sonin
 * @date 2021/1/11 14:40
 */
public class ApiTest {

    public static void main(String[] args) {
        //线程一
        new Thread(() -> new ApiTest().http_lt1()).start();

        //线程二
        new Thread(() -> {
            new ApiTest().http_lt1();
        }).start();
    }

    public void http_lt1() {
        System.out.println("测试结果：hi1");
        http_lt2();
    }

    public void http_lt2() {
        System.out.println("测试结果：hi2");
        http_lt3();
    }

    public void http_lt3() {
        System.out.println("测试结果：hi3");
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
