package com.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class RouteConfig {
@Bean
    public RouteLocator productAppRouteConfig(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p->p
                .path("/weatherservice/**")
                .filters(f->f.rewritePath("/weatherservice/(?<segment>.*)",
                        "/${segment}")
                        .addResponseHeader("X-Response-Header", LocalDateTime.now().toString()))
                .uri("lb://WSERVICES"))



                .route(p->p
                        .path("/weatherclient/**")
                        .filters(f->f.rewritePath("/weatherclient/(?<segment>.*)","/${segment}")
                                .addResponseHeader("X-Response-Header", LocalDateTime.now().toString()))
                        .uri("lb://WCLIENT"))
                .build();

    }
}
