package com.jw.myproject.myproject.pattern.proxy.dbrouter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lijw
 * @date 2020/10/29 9:58
 */
public class DbRouterProxyTest {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    public static void main(String[] args) {
        Order order = new Order();
        order.setCreateTime(new Date().getTime());

//        // 静态代理
//        IOrderService orderService = new OrderServiceStaticProxy(new OrderService());
//        orderService.createOrder(order);

        IOrderService iOrderService = (IOrderService) new OrderServiceDynamicProxy().getInstace(new OrderService());
        iOrderService.createOrder(order);
    }
}
