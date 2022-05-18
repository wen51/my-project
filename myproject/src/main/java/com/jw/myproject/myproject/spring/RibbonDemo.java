package com.jw.myproject.myproject.spring;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class RibbonDemo {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @LoadBalanced
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public void test() {
        restTemplate.getForObject("http://pangu-member-service/member/employee/48446709", RibbonDemo.class);
    }

}
