package com.jw.myproject.myproject.controller;

import com.jw.myproject.myproject.facade.FeignTestFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lijw
 * @date 2021/7/16 17:55
 */
@RestController
public class FeignCallController {

    @Resource
    private FeignTestFacade feignTestFacade;

    @GetMapping("feign-test")
    public String testFeign() {
        return feignTestFacade.hello();
    }
}
