package com.jw.myproject.myproject.test.spring.ioc;

public class MessageServiceImpl implements MessageService {
    @Override
    public String getMessage() {
        return "Hello World";
    }
}
