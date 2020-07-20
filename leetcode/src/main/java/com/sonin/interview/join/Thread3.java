package com.sonin.interview.join;

/**
 * @author sonin
 * @date 2020/7/20 10:55
 */
public class Thread3 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println(Thread.currentThread().getName() + "=====>" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
