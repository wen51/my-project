package com.jw.myproject.myproject.demo.jvm;

/**
 * @author lijw
 * @date 2021/11/30 17:58
 */
public class JHSDBTest {

    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done"); // 这里设一个断点
        }
    }

    private static class ObjectHolder {
    }

    public static void main(String[] args) {
        Test test = new JHSDBTest.Test();
        test.foo();
    }
}