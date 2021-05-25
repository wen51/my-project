package com.lijw.springcloud.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @author lijw
 * @date 2021/5/19 16:19
 */
@Configuration
public class CustomerResolver {
    private static final Logger logger = LoggerFactory.getLogger(CustomerResolver.class);

    @Bean
    public KeyResolver ipKeyResolver(){
        logger.info("logger---进入redis限流。。。。");
        System.out.println("进入redis限流。。。。。。。。。。。");
        return exchange -> Mono.just(Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getHostName());
    }
}
