package com.jw.myproject.myproject.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/rest")
public class TestController {

    @GetMapping(value = "/aopTest")
    public String aopTest(@RequestParam(value = "id", required = false) Integer id, @RequestParam(value = "name", required = false) Integer name){
        System.out.println("this is aop test");
        return "id="+id+",name="+name;
    }

    @PostMapping(value = "/postTest")
    public void postTest(HttpServletRequest request){
        System.out.println(request.getParameter("test"));
        System.out.println(request.getParameter("post"));
    }
}
