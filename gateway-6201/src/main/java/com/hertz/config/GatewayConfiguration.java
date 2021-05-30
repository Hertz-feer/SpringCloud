package com.hertz.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Hertz
 * @date 2021/5/30 15:19
 */
@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator myRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("code_route_hertz_1", pre ->
                        pre.path("/bilibili")
                                .uri("https://www.bilibili.com/")
                )
                .route("code_route_hertz_2", pre ->
                        pre.path("/zhihu")
                                .uri("https://www.zhihu.com/")
                ).build();
    }
}
