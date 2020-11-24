package com.sonin.base.bugstack;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

/**
 * @author sonin
 * @date 2020/11/24 9:48
 */
@Slf4j
public class SemaphoreTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("韦小宝");
        list.add("阿珂");
        list.add("双儿");
        list.add("曾柔");
        list.add("建宁公主");
        list.add("沐建屏");
        list.add("方怡");
        list.add("苏荃");
        Semaphore semaphore = new Semaphore(4, true);
        ExecutorService executorService = new MyExecutorService().getThreadPool();
        for (int i = 0; i < 8; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    String user = list.remove(new Random().nextInt(list.size()));
                    log.info("韦小宝带着七个老婆，过着桃园生活。每天打打麻将、练练武术。麻将四人桌：{}", user);
                    Thread.sleep(3000L);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }
    }
}
