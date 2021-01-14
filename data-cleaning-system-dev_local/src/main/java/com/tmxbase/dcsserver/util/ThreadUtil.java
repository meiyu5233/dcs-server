package com.tmxbase.dcsserver.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Designation:
 * @Author: Ylz
 * @Date: 2020/5/22
 * @Version: 1.0
 */
public class ThreadUtil {
    public static ThreadPoolExecutor docProcessExecutor = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(1000));

    public static ThreadPoolExecutor urlProcessexecutor = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(100), new ThreadPoolExecutor.DiscardOldestPolicy());
}
