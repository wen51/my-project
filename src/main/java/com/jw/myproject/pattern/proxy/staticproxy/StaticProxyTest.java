package com.jw.myproject.pattern.proxy.staticproxy;

/**
 * @author lijw
 * @date 2020/10/28 16:52
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        Father fa = new Father(new Son());
        fa.findLove();
    }
}
