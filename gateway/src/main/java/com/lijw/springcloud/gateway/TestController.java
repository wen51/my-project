package com.lijw.springcloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijw
 * @date 2021/5/19 15:36
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "Hello！";
    }
}
