package com.lijw.springcloud.gateway;

import com.alibaba.fastjson.JSONObject;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lijw
 * @date 2021/5/19 13:55
 */
//@Component
public class LimitFilter implements GlobalFilter, Ordered {
    private static final Logger logger = LoggerFactory.getLogger(LimitFilter.class);


    private int capacity;
    private int refillTokens;
    private Duration refillDuration;

    public LimitFilter() {
        this.capacity = 2;
        this.refillTokens = 1;
        this.refillDuration = Duration.ofSeconds(1);
    }

    private static final Map<String, Bucket> CACHE = new ConcurrentHashMap<>();

    private Bucket createNewBucket() {
        Refill refill = Refill.greedy(refillTokens, refillDuration);
        Bandwidth limit = Bandwidth.classic(capacity, refill);
        return Bucket4j.builder().addLimit(limit).build();
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String ip = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
        Bucket bucket = CACHE.computeIfAbsent(ip, k -> createNewBucket());
        logger.info("进入限流过滤器，ip：{}，avaliable token:{}", ip, bucket.getAvailableTokens());
        if (bucket.tryConsume(1L)) {
            return chain.filter(exchange);
        }
        logger.info("触发限流，ip:{}, avaliable token: {}", ip, bucket.getAvailableTokens());

        exchange.getResponse().getHeaders().add("Content-type","text/plain;charset=utf-8");
        return exchange.getResponse().writeWith(Mono.just(exchange.getResponse().bufferFactory().wrap("触发限流".getBytes())));
    }

//    private Bucket createBucket() {
//        Refill greedy = Refill.greedy(1, Duration.ofSeconds(1));
//    }

    @Override
    public int getOrder() {
        return 0;
    }
}
