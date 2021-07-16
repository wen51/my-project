package com.lijw.springcloud.demo.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijw
 * @date 2021/7/16 17:52
 */
@RestController
public class FeignTestController {

    @GetMapping("/feign/hello")
    public String hello() {
        return "Hello World!!!";
    }
}
