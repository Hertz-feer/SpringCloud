package com.hertz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Hertz
 * @date 2021/5/13 12:55
 */
@EnableEurekaClient
@SpringBootApplication
public class PaymentProducer6001Application {
    public static void main(String[] args) {
          SpringApplication.run(PaymentProducer6001Application.class, args);
     }
}
