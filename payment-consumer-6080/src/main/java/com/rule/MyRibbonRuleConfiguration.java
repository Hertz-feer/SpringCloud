package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Hertz
 * @date 2021/5/16 14:58
 */
@Configuration
public class MyRibbonRuleConfiguration {

    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
