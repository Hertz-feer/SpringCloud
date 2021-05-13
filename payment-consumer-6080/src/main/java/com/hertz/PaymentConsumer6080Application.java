package com.hertz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Hertz
 * @date 2021/5/13 13:01
 */
@EnableEurekaClient
@SpringBootApplication
public class PaymentConsumer6080Application {
    public static void main(String[] args) {
          SpringApplication.run(PaymentConsumer6080Application.class, args);
     }
}
