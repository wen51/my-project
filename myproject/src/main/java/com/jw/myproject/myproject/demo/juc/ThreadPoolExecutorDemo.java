package com.jw.myproject.myproject.demo.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lijw
 * @date 2022/6/1 16:45
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        executor.execute(() -> {
            System.out.println(123);
        });

        executor.

    }
}

//public class