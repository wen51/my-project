package com.jw.myproject.myproject.test.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        //使用配置文件来启动一个ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        System.out.println("context 启动成功");
        //从context中取出bean（此处可能包冲突，无法使用spring4的类）
//        MessageService messageService = (MessageService) context.getBean("messageService");
//        MessageService messageService = context.getBean(MessageService.class);
//        System.out.println(messageService.getMessage());
    }
}
