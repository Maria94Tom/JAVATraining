package com.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import java.time.Duration;
import java.time.LocalDateTime;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator productAppRouteConfig(RouteLocatorBuilder builder) {
        //URL:localhost:8079/weatherservice/weathersms/weatherservice/20
        //URL: localhost:8079/weatherclient/weathersms/weatherclient/20
        return builder.routes()
                .route(p -> p
                        .path("/weatherservice/weathersms/**")
                        .filters(f -> f
                                .rewritePath("/weatherservice/weathersms/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Header", LocalDateTime.now().toString())
                                .retry(config -> config.setRetries(3)
                                        .setMethods(HttpMethod.GET)
                                        .setBackoff(Duration.ofMillis(100), Duration.ofMillis(1000), 2, true))
                                .circuitBreaker(config -> config.setName("mycircuitbreaker")
                                        .setFallbackUri("forward:/contactSupport")))
                        .uri("lb://WSERVICE"))

                .route(p -> p
                        .path("/weatherclient/weathersms/**")
                        .filters(f -> f
                                .rewritePath("/weatherclient/weathersms/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Header", LocalDateTime.now().toString()))
                        .uri("lb://WCLIENT"))
                .build();
    }
}