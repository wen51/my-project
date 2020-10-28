package com.jw.myproject.pattern.singleton.lazy;

/**
 * @author lijw
 * @date 2020/10/23 9:55
 */
public class InnerClassSingleton {

    static {
        System.out.println("外部类静态块开始睡2秒..........");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("外部类进行了初始化！");
    }
    static InnerClassSingleton getInstance() {
        return InnerClass.SINGLETON;
    }

    private static class InnerClass {
        static {
            System.out.println("静态内部类静态块开始睡2秒..........");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SINGLETON = new InnerClassSingleton();
            System.out.println("静态内部类进行了初始化！");
        }

        private static final InnerClassSingleton SINGLETON;
    }
}
