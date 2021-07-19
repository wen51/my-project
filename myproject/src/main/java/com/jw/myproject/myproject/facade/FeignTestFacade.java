package com.jw.myproject.myproject.facade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lijw
 * @date 2021/7/16 17:56
 */
@FeignClient(value = "aaaa", url = "http://localhost:8081")
public interface FeignTestFacade {

    @GetMapping("/feign/hello")
    String hello();
}
