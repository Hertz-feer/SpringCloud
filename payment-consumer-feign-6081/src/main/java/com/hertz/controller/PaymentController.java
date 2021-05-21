package com.hertz.controller;

import com.hertz.entities.CommonResult;
import com.hertz.entities.Payment;
import com.hertz.service.PaymentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Hertz
 * @date 2021/5/17 16:53
 */
@RestController
@RequestMapping("payment/consumer/feign")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @RequestMapping("list")
    public CommonResult<List<Payment>> listPayments() {
        return service.listPayments();
    }

    @RequestMapping("time/out/list")
    public CommonResult<List<Payment>> listTimeOutPayments() {
        return service.limeOutLstPayments();
    }
}
