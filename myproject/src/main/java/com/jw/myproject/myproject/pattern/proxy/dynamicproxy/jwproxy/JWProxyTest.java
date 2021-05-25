package com.jw.myproject.myproject.pattern.proxy.dynamicproxy.jwproxy;

import com.jw.myproject.myproject.pattern.proxy.dynamicproxy.jdkproxy.Girl;
import com.jw.myproject.myproject.pattern.proxy.staticproxy.Person;

/**
 * @author lijw
 * @date 2020/10/29 18:26
 */
public class JWProxyTest {

    public static void main(String[] args) {
        try {
            Person person = (Person) new JWMeipo().getInstance(new Girl());
            System.out.println(person.getClass());
            person.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
