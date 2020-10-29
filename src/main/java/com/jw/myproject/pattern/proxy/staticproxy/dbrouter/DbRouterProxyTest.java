package com.jw.myproject.pattern.proxy.staticproxy.dbrouter;

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
        order.setCrateTime(new Date().getTime());

        IOrderService orderService = new OrderServiceStaticProxy(new OrderService());
        orderService.createOrder(order);


    }
}
