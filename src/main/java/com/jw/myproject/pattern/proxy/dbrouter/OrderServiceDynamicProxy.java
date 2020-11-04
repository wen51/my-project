package com.jw.myproject.pattern.proxy.dbrouter;

import com.jw.myproject.pattern.proxy.dbrouter.db.DynamicDataSourceEntity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 动态代理实现数据源自动切换
 * @author lijw
 * @date 2020/10/29 9:55
 */
public class OrderServiceDynamicProxy implements InvocationHandler {

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    Object proxyObj;
    public Object getInstace(Object proxyObj) {
        this.proxyObj = proxyObj;
        Class<?> clazz = proxyObj.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.before(args[0]);
        Object object = method.invoke(proxyObj, args);
        this.after();
        return object;
    }

    /**
     * @param target 目标对象order
     */
    private void before(Object target) throws Exception {
        System.out.println("Proxy before method。。。。。");
        //切换数据源
        Long time = (Long) target.getClass().getMethod("getCreateTime").invoke(target);
        Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
        System.out.println("静态代理类自动分配到【DB_" + dbRouter + "】数据源处理数据");
        DynamicDataSourceEntity.set(dbRouter);
    }

    /**
     * 事后处理
     */
    private void after() {
        System.out.println("Proxy after method。。。。。");
        // 重置数据源
        DynamicDataSourceEntity.restore();
    }
}
