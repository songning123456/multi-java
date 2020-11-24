package com.sonin.base.bugstack;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author sonin
 * @date 2020/11/24 9:12
 */
@Slf4j
public class SynchronizedTest {

    private static volatile boolean laobao = false;

    public static class keguan implements Runnable {
        private String name;

        public keguan(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                qingwuan(name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void qingwuan(String name) throws InterruptedException {
        while (true) {
            log.info("韦春花与 {} 喝茶、吟诗、做对、聊风月！", name);
            if (laobao) {
                log.info("老鸨敲门：时间到啦！");
                laobao = false;
                break;
            }
            Thread.sleep(1000);
        }
    }

    private static List<String> list = Arrays.asList("鳌大人", "陈近南", "海大富");

    public static void main(String[] args) throws InterruptedException {
        ExecutorService lichunyuan = new MyExecutorService().getThreadPool();
        for (int i = 0; i < 3; i++) {
            lichunyuan.execute(new keguan(list.get(i)));
            Thread.sleep(3000);
            laobao = true;
        }
    }
}
