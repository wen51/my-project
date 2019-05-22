package com.jw.myproject.controller;

import com.jw.myproject.utils.thread.MyRunnable;
import com.jw.myproject.utils.thread.MyThread;

import java.util.concurrent.ThreadPoolExecutor;

public class ThreadController {

    public static void main(String[] args) {
        MyThread m = new MyThread();
        m.start();

        Runnable r = new MyRunnable();
        r.run();

//        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor();
//        poolExecutor.
    }
}
