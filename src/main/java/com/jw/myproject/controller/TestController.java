package com.jw.myproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest")
public class TestController {

    @GetMapping(value = "/aopTest")
    public String aopTest(){
        System.out.println("this is aop test");
        return "test success";
    }
}
