package com.jw.myproject.myproject.pattern.proxy.dynamicproxy.jdkproxy;

import com.jw.myproject.myproject.pattern.proxy.staticproxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lijw
 * @date 2020/10/29 15:56
 */
public class JDKMeipo implements InvocationHandler {

    private Person target;

    public Object getInstance(Person person) throws Exception {
        this.target = person;
        Class<? extends Person> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.before();
        Object invoke = method.invoke(this.target, args);
        this.after();
        return invoke;
    }

    private void before() {
        System.out.println("媒婆：我是媒婆，我要给你找对象，现在已经确认你的需求");
        System.out.println("开始物色.........");
    }

    private void after() {
        System.out.println("OK的话，开始办事吧");
    }
}
