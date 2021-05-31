package com.hertz.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Hertz
 * @date 2021/5/31 17:52
 */
@Slf4j
@Component
public class MyLogGatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("this is MyLogGatewayFilter " + LocalDateTime.now());
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (Objects.isNull(username)){
            log.info("username is null 非法用户");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }else {
            log.info("username is "+username+" 放行");
            return chain.filter(exchange);
        }
    }

    /**
     * 加载顺序
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
