package com.sonin.base.bugstack;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author sonin
 * @date 2020/11/24 9:38
 */
@Slf4j
public class CountDownLatchTest {

    public static void main(String[] args) throws Exception {
        int num = 10;
        List<String> list = Arrays.asList("总舵主，陈近南", "莲花堂香主，蔡德忠", "洪顺堂香主，方大洪", "家后堂香主，马超兴", "参太堂香主，胡德帝", "宏化堂香主，李式开", "青木堂香主，韦小宝", "赤火堂香主，古至中", "玄水堂香主，林永超", "黄土堂香主，姚必达");
        CountDownLatch countDownLatch = new CountDownLatch(num);
        ExecutorService executorService = new MyExecutorService().getThreadPool();
        for (int i = 0; i < num; i++) {
            int idx = i;
            executorService.execute(() -> {
                try {
                    log.info("天地会核心十堂核心成员，高层会议，成员：{} 入场", list.get(idx));
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        log.info("天地会，核心成员到齐。开会讨论谁入宫，偷取四十二章经！「内定韦香主」");
        executorService.shutdown();
    }
}
