package com.jw.myproject.myproject.pattern.observer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lijw
 * @date 2021/6/25 16:26
 */
@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public MyPublisher myPublisher() {
        return new MyPublisher();
    }
}
