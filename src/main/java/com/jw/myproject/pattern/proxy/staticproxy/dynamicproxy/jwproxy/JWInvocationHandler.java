package com.jw.myproject.pattern.proxy.staticproxy.dynamicproxy.jwproxy;

import java.lang.reflect.Method;

/**
 * @author lijw
 * @date 2020/10/29 16:12
 */
public interface JWInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;

}
