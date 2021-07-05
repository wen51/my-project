package com.jw.myproject.myproject.pattern.observer;

import org.springframework.context.ApplicationEvent;

/**
 * @author lijw
 * @date 2021/6/25 16:16
 */
public class MyEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyEvent(Object source) {
        super(source);
        System.out.println("MyEvent");
    }
}
