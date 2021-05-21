package com.hertz.controller;

import com.hertz.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hertz
 * @date 2021/5/10 20:44
 */
@Slf4j
@RestController
@RequestMapping("payment/hystrix")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @RequestMapping("send/ok/{id}")
    public String sendOK(@PathVariable Integer id) {
        return service.sendOK(id);
    }

    @RequestMapping("send/error/{id}")
    public String sendError(@PathVariable Integer id) {
        return service.sendError(id);
    }

    @RequestMapping("send/error/by/{id}")
    public String sendErrorById(@PathVariable Integer id) {
        return service.sendErrorById(id);
    }
}
