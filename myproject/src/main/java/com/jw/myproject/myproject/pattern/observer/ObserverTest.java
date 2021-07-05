package com.jw.myproject.myproject.pattern.observer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lijw
 * @date 2021/6/25 16:27
 */
public class ObserverTest {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyPublisher publisher = context.getBean(MyPublisher.class);
        publisher.publishEvent(new MyEvent("起床啦！！！"));
        System.out.println();
    }
}
