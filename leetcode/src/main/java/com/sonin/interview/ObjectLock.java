package com.sonin.interview;

/**
 * @author sonin
 * @date 2020/7/16 22:24
 */
public class ObjectLock implements Runnable {
    Demo demo;

    public ObjectLock(Demo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        demo.getI(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Demo demo = new Demo(1);
        Thread thread = new Thread(new ObjectLock(demo), "thread0");
        Thread thread1 = new Thread(new ObjectLock(demo), "thread1");
        Thread thread2 = new Thread(new ObjectLock(new Demo(2)), "thread2");
        thread.start();
        thread1.start();
        thread2.start();
    }
}

class Demo {

    private int i;

    Demo(int i) {
        this.i = i;
    }

    public static synchronized void staticGetI(String s) {
        for (int j = 0; j < 10000; j++) {
//            System.out.println(i + "---------" + s);
        }
    }

    public synchronized void getI(String s) {
        for (int j = 0; j < 10000; j++) {
            System.out.println(i + "---------" + s);
        }
    }
}
