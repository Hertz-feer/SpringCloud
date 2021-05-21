package com.hertz.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Hertz
 * @date 2021/5/17 21:23
 */
@Component
@FeignClient(value = "PAYMENT-PRODUCER-HYSTRIX", fallback = PaymentFallBackService.class)
public interface PaymentService {

    @RequestMapping("/payment/hystrix/send/ok/{id}")
    String sendOK(@PathVariable("id") Integer id);

    @RequestMapping("/payment/hystrix/send/error/{id}")
    String sendError(@PathVariable("id") Integer id);
}
