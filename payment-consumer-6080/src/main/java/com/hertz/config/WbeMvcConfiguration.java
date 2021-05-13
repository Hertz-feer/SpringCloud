package com.hertz.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author Hertz
 * @date 2021/5/12 10:35
 */
@Configuration
public class WbeMvcConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(60 * 1000);
        requestFactory.setReadTimeout(60 * 1000);
        return new RestTemplate(requestFactory);
    }
}
