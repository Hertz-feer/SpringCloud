package com.hertz;

import com.rule.MyRibbonRuleConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author Hertz
 * @date 2021/5/13 13:01
 */
@RibbonClient(name = "PAYMENT-PRODUCER-SERVER", configuration = MyRibbonRuleConfiguration.class)
@EnableEurekaClient
@SpringBootApplication
public class PaymentConsumer6080Application {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsumer6080Application.class, args);
    }
}
