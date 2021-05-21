package com.hertz.controller;

import com.hertz.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hertz
 * @date 2021/5/17 21:25
 */
@RestController
@RequestMapping("/payment/consumer/feign/hystrix")
@DefaultProperties(defaultFallback = "defaultSendSomethingCommand")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @RequestMapping("/send/ok/{id}")
    public String sendOK(@PathVariable Integer id) {
        return service.sendOK(id);
    }

    @HystrixCommand(fallbackMethod = "sendSomethingCommand", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    @RequestMapping("/send/error/{id}")
    public String sendError(@PathVariable Integer id) {
        return service.sendError(id);
    }

    @HystrixCommand
    @RequestMapping("/default/send/error/{id}")
    public String sendDefaultError(@PathVariable Integer id) {
        return service.sendError(id);
    }

    public String sendSomethingCommand(Integer id) {
        return "this is consume 6084, my provider is busy /(ㄒoㄒ)/~~";
    }

    public String defaultSendSomethingCommand() {
        return "this is consume default fall back function 6084, my provider is busy /(ㄒoㄒ)/~~";
    }


}
