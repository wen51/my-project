package com.jw.myproject.test.thread;

import com.jw.myproject.test.thread.ThreadTest;
import lombok.Data;

@Data
public class Test {

    private static ThreadException threadException = new ThreadException();

    public static void main(String[] args) {
//        testConsumer();
//        testAddSum();
        newThread(20);
    }

    private static void testAddSum() {
        ThreadTest threadTest = new ThreadTest();
        for(int i=0; i< 20; i++){
            ThreadTest.Sum sum = threadTest.new Sum(threadTest);
            sum.start();
        }
    }

    private static void testConsumer() {
        ThreadTest test = new ThreadTest();
        ThreadTest.Producer p1 = test.new Producer(test);
        ThreadTest.Producer p2 = test.new Producer(test);
        ThreadTest.Producer p3 = test.new Producer(test);
        ThreadTest.Producer p4 = test.new Producer(test);
        ThreadTest.Producer p5 = test.new Producer(test);
        ThreadTest.Producer p6 = test.new Producer(test);
        ThreadTest.Producer p7 = test.new Producer(test);
        ThreadTest.Producer p8 = test.new Producer(test);
        ThreadTest.Producer p9 = test.new Producer(test);
        ThreadTest.Producer p10 = test.new Producer(test);

        ThreadTest.Consumer c1 = test.new Consumer(test);
        ThreadTest.Consumer c2 = test.new Consumer(test);
        ThreadTest.Consumer c3 = test.new Consumer(test);
        ThreadTest.Consumer c4 = test.new Consumer(test);
        ThreadTest.Consumer c5 = test.new Consumer(test);
        ThreadTest.Consumer c6 = test.new Consumer(test);
        ThreadTest.Consumer c7 = test.new Consumer(test);
        ThreadTest.Consumer c8 = test.new Consumer(test);
        ThreadTest.Consumer c9 = test.new Consumer(test);

        p1.setNum(10);
        p2.setNum(20);
        p3.setNum(30);
        p4.setNum(40);
        p5.setNum(50);
        p6.setNum(60);
        p7.setNum(40);
        p8.setNum(80);
        p9.setNum(10);
        p10.setNum(10);

        c1.setNum(50);
        c2.setNum(30);
        c3.setNum(20);
        c4.setNum(80);
        c5.setNum(20);
        c6.setNum(20);
        c7.setNum(40);
        c8.setNum(20);
        c9.setNum(70);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
        p8.start();
        p9.start();
        p10.start();
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
        c7.start();
        c8.start();
        c9.start();
    }

    private static void newThread(int count){
        if(count < 5){
            count = 5;
        }
        for (int i=0; i< count; i++){
            ThreadTest2 t = new ThreadTest2();
            t.start();
//            t.setUncaughtExceptionHandler(threadException);
        }
        Thread.setDefaultUncaughtExceptionHandler(threadException);
    }
}
