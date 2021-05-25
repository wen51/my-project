package com.jw.myproject.myproject.pattern.proxy.dbrouter;

/**
 * @author lijw
 * @date 2020/10/29 9:41
 */
public class OrderService implements IOrderService {

    private OrderDao orderDao;

    public OrderService() {
        //如果使用Spring应该是自动注入的，这里为了使用方便，在构造方法中直接初始化
        this.orderDao = new OrderDao();
    }

    @Override
    public int createOrder(Order order) {
        System.out.println("OrderService调用OrderDao处理数据创建订单。");
        orderDao.insert();
        return 0;
    }
}
