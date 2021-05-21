package com.hertz;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

/**
 * @author Hertz
 * @date 2021/5/21 11:46
 */
@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerHystrixDashboard6201Application {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixDashboard6201Application.class, args);
    }
}
