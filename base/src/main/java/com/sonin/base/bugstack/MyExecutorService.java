package com.sonin.base.bugstack;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author sonin
 * @date 2020/11/24 9:39
 */
public class MyExecutorService {

    public ExecutorService getThreadPool() {
        int nThreads = Runtime.getRuntime().availableProcessors();
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("sonin-pool-%d").build();
        return new ThreadPoolExecutor(nThreads, 2 * nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
    }
}
