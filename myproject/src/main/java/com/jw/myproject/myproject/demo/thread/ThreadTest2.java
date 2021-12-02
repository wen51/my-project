package com.jw.myproject.myproject.demo.thread;

public class ThreadTest2 extends Thread {

    private static Integer num = 7;
    private volatile static Integer count = 200;

//    @Override
//    public void run() {
//        Thread thread = Thread.currentThread();
////        printThreadState(thread);
//
//        num++;
////        System.out.println("num++..., num="+num);
////        if (num % 9 == 0){
////            num.notifyAll();
////            System.out.println(thread.getName()+" notifyAll,num ="+ num);
////            printThreadState(thread);
////        }
//        synchronized (num) {
//            if(num % 2 == 0){
//    //            throw new RuntimeException("（异常）num是5的倍数");
//                try {
//                    System.out.println(thread.getName()+": current thread is in interrupt...");
//                    thread.interrupt();
//                    System.out.println("current is interrupted:"+thread.isInterrupted());
//                    System.out.println(thread.getName()+": current thread sleeping");
//                    Thread.sleep(30 * 1000);
//
//                    num.wait();
//                    System.out.println(thread.getName()+": current thread awake");
//                    System.out.println(thread.getName()+": current thread state: "+thread.getState());
//                } catch (InterruptedException e) {
////                    e.printStackTrace();
//                    System.out.println(thread.getName()+"InterruptedException");
//                    System.out.println("interrupted:"+thread.isInterrupted());
//                }
//            }
//        }
//        synchronized (num) {
//            if(num % 2 == 0){
//    //            throw new RuntimeException("（异常）num是5的倍数");
//                try {
//                    System.out.println(thread.getName()+": current thread sleeping");
//                    Thread.sleep(30 * 1000);
//                    num.wait();
//                    System.out.println(thread.getName()+": current thread awake");
//                    System.out.println(thread.getName()+": current thread state: "+thread.getState());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }


    @Override
    public void run() {
        count++;
        System.out.println("count="+count);
    }

    private void printThreadState(Thread thread) {
        ThreadGroup threadGroup = thread.getThreadGroup();
        int threadNum = threadGroup.activeCount();
        Thread[] threads = new Thread[threadNum];
        threadGroup.enumerate(threads);
        System.out.println("------------"+thread.getName()+" print start----------------");
        for(int i = 0; i<threadNum; i++){
            try {
                System.out.println(threads[i].getName()+",notified state："+threads[i].getState());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("--------------"+thread.getName()+" print finish--------------");
        System.out.println("|<");
    }
}
