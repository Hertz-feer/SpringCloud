package com.hertz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Hertz
 * @date 2021/5/13 14:37
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentProducer6002Application {
    public static void main(String[] args) {
        SpringApplication.run(PaymentProducer6002Application.class, args);
    }
}
