package com.jw.myproject.myproject.demo.juc;

/**
 * @author lijw
 * @date 2022/6/1 16:43
 */
public class ThreadInterruptDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t =
                new Thread(
                        () -> {
                            System.out.println("正在执行任务.........");
                            while (!Thread.currentThread().isInterrupted()) {
                                long now = System.currentTimeMillis();
                                while (System.currentTimeMillis() - now < 200) {

                                }
                                System.out.println("执行完一次任务");
                            }
                            System.out.println("线程是否中断=" + Thread.currentThread().isInterrupted());

                            try {
                                Thread.sleep(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                System.out.println("已中断子线程=" + Thread.currentThread().isInterrupted());
                            }
                            System.out.println("子线程结束");
                        });
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        System.out.println("已中断线程=" + t.isInterrupted());
        Thread.sleep(1000);
        System.out.println("线程中断状态后：" + t.isInterrupted());
    }
}
