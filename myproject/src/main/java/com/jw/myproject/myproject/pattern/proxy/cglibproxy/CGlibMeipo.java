package com.jw.myproject.myproject.pattern.proxy.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibMeipo implements MethodInterceptor {

    public Object getInstance(Class<?> clazz) throws Exception {
        //相当于Proxy，代理工具类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        this.before();
        Object invoke = methodProxy.invokeSuper(o, objects);
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
