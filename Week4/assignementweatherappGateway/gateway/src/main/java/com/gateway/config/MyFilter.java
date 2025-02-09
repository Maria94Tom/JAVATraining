package com.gateway.config;


import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class MyFilter implements GlobalFilter {
    private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MyFilter.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("Path of request->{}",exchange.getRequest().getPath());
        return chain.filter(exchange);

    }
}
