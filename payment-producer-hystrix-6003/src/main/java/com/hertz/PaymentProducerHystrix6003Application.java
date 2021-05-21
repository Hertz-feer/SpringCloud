package com.hertz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Hertz
 * @date 2021/5/17 20:52
 */
@EnableEurekaServer
@EnableCircuitBreaker
@SpringBootApplication
public class PaymentProducerHystrix6003Application {
    public static void main(String[] args) {
        SpringApplication.run(PaymentProducerHystrix6003Application.class, args);
    }
}
