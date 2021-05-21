package com.hertz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Hertz
 * @date 2021/5/17 16:45
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class PaymentConsumerFeign6081Application {
    public static void main(String[] args) {
          SpringApplication.run(PaymentConsumerFeign6081Application.class, args);
     }
}
