package com.jw.myproject.myproject.pattern.observer;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author lijw
 * @date 2021/6/25 16:22
 */
@Component
public class MyListenerB implements ApplicationListener<MyEvent> {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("MyListenerB 收到事件变更消息，消息内容：" + event.getSource());
    }
}
