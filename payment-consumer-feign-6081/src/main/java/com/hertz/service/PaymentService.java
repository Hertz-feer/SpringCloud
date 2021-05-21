package com.hertz.service;

import com.hertz.entities.CommonResult;
import com.hertz.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Hertz
 * @date 2021/5/17 16:48
 */
@Component
@FeignClient(value = "PAYMENT-PRODUCER-SERVER")
public interface PaymentService {

    @RequestMapping("/payment/list")
    CommonResult<List<Payment>> listPayments();

    @RequestMapping("/payment/time/out/list")
    CommonResult<List<Payment>> limeOutLstPayments();
}
