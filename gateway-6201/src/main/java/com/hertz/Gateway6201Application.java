package com.hertz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Hertz
 * @date 2021/5/30 14:50
 */
@EnableEurekaClient
@SpringBootApplication
public class Gateway6201Application {
    public static void main(String[] args) {
          SpringApplication.run(Gateway6201Application.class, args);
     }
}
