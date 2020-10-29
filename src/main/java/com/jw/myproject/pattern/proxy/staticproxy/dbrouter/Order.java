package com.jw.myproject.pattern.proxy.staticproxy.dbrouter;

import lombok.Data;

/**
 * 订单实体
 * @author lijw
 * @date 2020/10/29 9:38
 */
@Data
public class Order {

    private String id;

    private Object orderInfo;

    /**
     * 根据订单创建时间进行按年分库
     */
    private Long crateTime;
}
