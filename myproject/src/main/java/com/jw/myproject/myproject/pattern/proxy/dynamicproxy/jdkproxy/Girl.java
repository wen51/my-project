package com.jw.myproject.myproject.pattern.proxy.dynamicproxy.jdkproxy;

import com.jw.myproject.myproject.pattern.proxy.staticproxy.Person;

/**
 * @author lijw
 * @date 2020/10/29 15:55
 */
public class Girl implements Person {
    /**
     * 找对象
     */
    @Override
    public void findLove() {
        System.out.println("Girl要求：高富帅、身高180cm、有6块腹肌");
    }
}
