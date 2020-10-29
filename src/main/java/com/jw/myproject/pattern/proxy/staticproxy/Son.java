package com.jw.myproject.pattern.proxy.staticproxy;

/**
 * @author lijw
 * @date 2020/10/28 16:50
 */
public class Son implements Person {
    /**
     * 找对象
     */
    @Override
    public void findLove() {
        System.out.println("儿子要求：肤白貌美大长腿");
    }
}
