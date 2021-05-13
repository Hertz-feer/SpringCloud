package com.hertz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Hertz
 * @date 2021/5/13 12:35
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaColonyService6111Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaColonyService6111Application.class, args);
    }
}
