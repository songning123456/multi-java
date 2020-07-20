package com.sonin.interview.join;

/**
 * @author sonin
 * @date 2020/7/20 10:55
 */
public class TestJoin1Main {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Thread1(), "线程1");
        Thread thread2 = new Thread(new Thread2(), "线程2");
        Thread thread3 = new Thread(new Thread3(), "线程3");

        try {
            thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();
            thread3.start();
            thread3.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
