package com.jw.myproject.pattern.proxy.dynamicproxy.jwproxy;

import java.lang.reflect.Method;

/**
 * 代理
 * @author lijw
 * @date 2020/10/29 15:56
 */
public class JWMeipo implements JWInvocationHandler {

    private Object obj;

    public Object getInstance(Object obj) throws Exception {
        this.obj = obj;
        Class<?> clazz = this.obj.getClass();
        return JWProxy.newProxyInstance(new JWClassLoder(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.before();
        Object invoke = method.invoke(this.obj, args);
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
