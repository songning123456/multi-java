package com.sonin.interview;

/**
 * @author sonin
 * @date 2020/7/17 16:09
 */
public class SynchronizedDemo {
    public void method() {
        synchronized (this) {
            System.out.println("synchronized代码块");
        }
    }
}
