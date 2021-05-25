package com.jw.myproject.myproject.pattern.singleton.lazy;

/**
 * @author lijw
 * @date 2020/10/23 10:08
 */
public class InnerClassTest {

    public static void main(String[] args) {
//        Thread t1 = new Thread(() -> {
            InnerClassSingleton s = InnerClassSingleton.getInstance();
            System.out.println(s);
//        }, "线程1");
//        Thread t2 = new Thread(() -> {
//            InnerClassSingleton s = InnerClassSingleton.getInstance();
//            System.out.println(s);
//        }, "线程2");

//        t1.start();
//        t2.start();
    }
}
