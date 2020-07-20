package com.sonin.interview.join;

/**
 * @author sonin
 * @date 2020/7/20 11:01
 */
public class TestJoin2Main {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName() + "=====>" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程1");
        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName() + "=====>" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程2");
        Thread thread3 = new Thread(() -> {
            try {
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName() + "=====>" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
