package com.jw.myproject.myproject.spring;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

public class RibbonDemo {

    @LoadBalanced
    @Resource
    private RestTemplate restTemplate;

    public void test() {
        restTemplate.getForObject("", null);
    }

}
