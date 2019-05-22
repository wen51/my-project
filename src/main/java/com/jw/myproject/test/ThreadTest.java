package com.jw.myproject.test;

import lombok.Data;

import java.util.LinkedList;

public class ThreadTest {

    private final int MAX_SIZE = 100;

    private LinkedList list = new LinkedList();

    private StringBuilder sb = new StringBuilder();

    /**
     * 生产
     * @param num
     */
    public void produce(int num){
        synchronized (list){
            while (list.size() + num > MAX_SIZE){
//                System.out.println(Thread.currentThread().getName()+"【要生产的产品数量】："+ num + "\t 【库存量】：" + list.size() + "\t暂时不能执行生产任务！");
                try {
                    //条件不满足，生产阻塞
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for(int i = 0; i<num; i++){
                list.add(new Object());
            }
//            System.out.println(Thread.currentThread().getName()+"【已生产产品数】：" + num + "\t【现仓储量为】："+list.size());
            list.notifyAll();
        }
    }

    public void consume(int num){
        System.out.println("当前线程："+Thread.currentThread().getName()+",state:"+Thread.currentThread().getState());
        printThreadState();

        synchronized (list) {
            System.out.println("---------------争夺锁完毕---------------------");
            System.out.println("夺到锁的线程："+Thread.currentThread().getName()+",state:"+Thread.currentThread().getState());
            printThreadState();
            while (list.size() < num){
//                System.out.println(Thread.currentThread().getName()+"【要消费的产品数量】："+ num + "\t 【库存量】：" + list.size() + "\t暂时不能执行消费任务！");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i =0; i < num; i++){
                list.remove();
            }
//            System.out.println(Thread.currentThread().getName()+"【已消费产品数】：" + num + "\t【现仓储量为】："+list.size());
            list.notifyAll();
        }
    }

    public void addSum(){
//        printThreadState();
        synchronized (sb){
            Thread thread = Thread.currentThread();
//            System.out.println(thread.getName() +"争夺到锁-------------");
            printThreadState();
//            try {
//                Thread.sleep(3 * 1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            sb.append("2");
            System.out.println("--------------------------sb:"+ sb);
            while (sb.toString().length() % 2 == 0){
                try {
                    sb.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(thread.getName()+"执行完毕");
        }
    }

    private void printThreadState() {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        int threadNum = threadGroup.activeCount();
        Thread[] threads = new Thread[threadNum];
        threadGroup.enumerate(threads);
        for(int i = 0; i<threadNum; i++){
            try {
                System.out.println(threads[i].getName()+",state："+threads[i].getState());
            } catch (Exception e) {
                System.out.println("---------------异常开始---------------");
                e.printStackTrace();
                System.out.println(threads[i]);
                System.out.println("-------------异常完成-------------");
            }
        }
        System.out.println("----------------打印完成----------------------");
    }

    @Data
    public class Producer extends Thread{
        private int num;
        private ThreadTest threadTest;

        public Producer(ThreadTest threadTest) {
            this.threadTest = threadTest;
        }

        @Override
        public void run() {
            produce(num);
        }

        public void produce(int num){
            threadTest.produce(num);
        }
    }

    @Data
    public class Consumer extends Thread{
        private int num;
        private ThreadTest threadTest;

        public Consumer(ThreadTest threadTest) {
            this.threadTest = threadTest;
        }

        @Override
        public void run() {
            consume(num);
        }

        public void consume(int num){
            threadTest.consume(num);
        }
    }

    @Data
    public class Sum extends Thread{
        private ThreadTest threadTest;

        public Sum(ThreadTest threadTest) {
            this.threadTest = threadTest;
        }

        @Override
        public void run() {
            addSum();
        }

        public void addSum(){
            threadTest.addSum();
        }
    }
}
