package com.lijw.springcloud.demo.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijw
 * @date 2021/5/19 15:56
 */
@RestController
public class DemoController {

    @GetMapping("hello")
    public String hello() {
        return "Hello World!!!";
    }
}
