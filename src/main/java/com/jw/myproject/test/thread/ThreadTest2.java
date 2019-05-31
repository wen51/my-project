package com.jw.myproject.test.thread;

public class ThreadTest2 extends Thread {

    private static int num = 0;

    @Override
    public void run() {
        num++;
        if(num % 5 == 0){
            throw new RuntimeException("（异常）num是5的倍数");
        }
    }
}
