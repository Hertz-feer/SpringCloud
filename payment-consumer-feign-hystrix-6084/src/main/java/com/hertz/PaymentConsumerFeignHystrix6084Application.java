package com.hertz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Hertz
 * @date 2021/5/17 21:21
 */
@EnableFeignClients
@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
public class PaymentConsumerFeignHystrix6084Application {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsumerFeignHystrix6084Application.class, args);
    }
}
