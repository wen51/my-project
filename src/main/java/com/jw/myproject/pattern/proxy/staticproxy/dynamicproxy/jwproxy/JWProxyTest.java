package com.jw.myproject.pattern.proxy.staticproxy.dynamicproxy.jwproxy;

import com.jw.myproject.pattern.proxy.staticproxy.Person;
import com.jw.myproject.pattern.proxy.staticproxy.dynamicproxy.jdkproxy.Girl;

/**
 * @author lijw
 * @date 2020/10/29 18:26
 */
public class JWProxyTest {

    public static void main(String[] args) {
        try {
            Person person = (Person) new JWMeipo().getInstance(new Girl());
            person.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
