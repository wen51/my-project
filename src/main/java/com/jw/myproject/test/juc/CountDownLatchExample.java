package com.jw.myproject.test.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {

    private static CountDownLatch c = new CountDownLatch(5);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        for (int i = 0; i <5; i++) {
            executorService.execute(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(1000);
                                System.out.println("-1");
                                c.countDown();
                                System.out.println("子线程执行。。。");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }
        System.out.println("等待。。。。");
        c.await();
        System.out.println("执行。。。");
        System.out.println("执行完成");
        executorService.shutdown();
    }
}
