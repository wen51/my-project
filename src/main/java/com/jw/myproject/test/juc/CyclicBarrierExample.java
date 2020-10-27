package com.jw.myproject.test.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {

    private static CyclicBarrier c = new CyclicBarrier(5);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executorService.execute(
                    () -> {
                        try {
                            Thread.sleep(1000);
                            System.out.println("等待。。。");
                            c.await();
                            System.out.println("执行完一个");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (BrokenBarrierException e) {
                            e.printStackTrace();
                        }
                    });
        }
        System.out.println("均执行完");
    }
}
