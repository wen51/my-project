package com.jw.myproject.myproject.demo.jvm;

/**
 * @author lijw
 * @date 2021/11/23 17:52
 */
public class EdenAllocateTest {

    public static final int _1MB = 1024 * 1024;

    /**
     * JVM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void main(String[] args) {
        byte[] a1, a2, a3, a4;
//        a1 = new byte[2 * _1MB];
//        a2 = new byte[2 * _1MB];
//        a3 = new byte[2 * _1MB];
//        // 会发生一次Minor GC
        a4 = new byte[4 * _1MB];
    }
}
