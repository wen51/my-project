package com.jw.myproject.pattern.proxy.dynamicproxy.jdkproxy;

import com.jw.myproject.pattern.proxy.staticproxy.Person;

/**
 * @author lijw
 * @date 2020/10/29 15:59
 */
public class JDKProxyTest {

    public static void main(String[] args) {
        try {
            Person obj = (Person) new JDKMeipo().getInstance(new Girl());
            obj.findLove();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
