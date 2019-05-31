package com.jw.myproject.test.thread;

public class ThreadTest2 extends Thread {

    private static Integer num = 10000;

    @Override
    public void run() {
        num++;
        synchronized (num) {
            if(num % 2 == 0){
    //            throw new RuntimeException("（异常）num是5的倍数");
                try {
                    Thread.sleep(30 * 1000);
                    Thread thread = Thread.currentThread();
                    System.out.println(thread.getName()+": current thread state: "+thread.getState());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (num % 9 == 0){
                num.notifyAll();
                ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
                int threadNum = threadGroup.activeCount();
                Thread[] threads = new Thread[threadNum];
                threadGroup.enumerate(threads);
                for(int i = 0; i<threadNum; i++){
                    try {
                        System.out.println(threads[i].getName()+",notified state："+threads[i].getState());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
