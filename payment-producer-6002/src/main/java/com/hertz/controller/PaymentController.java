package com.hertz.controller;

import com.hertz.entities.CommonResult;
import com.hertz.entities.Payment;
import com.hertz.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Hertz
 * @date 2021/5/10 20:44
 */
@Slf4j
@RestController
@RequestMapping("payment")
public class PaymentController {

    private final PaymentService service;

    private final String serverPort;

    private final DiscoveryClient discoveryClient;

    public PaymentController(PaymentService service, @Value("${server.port}") String serverPort, DiscoveryClient discoveryClient) {
        this.service = service;
        this.serverPort = serverPort;
        this.discoveryClient = discoveryClient;
    }

    @RequestMapping("save")
    public CommonResult<Payment> savePayment(@RequestBody Payment payment) {
        long id = service.savePayment(payment);
        payment.setId(id);
        log.info("save payment =>" + payment);
        return CommonResult.create(id > 0, "来自" + serverPort + "：插入", payment);
    }

    @RequestMapping("get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return CommonResult.create(200, "来自" + serverPort, service.getPaymentById(id));
    }

    @RequestMapping("list")
    public CommonResult<List<Payment>> listPayments() {
        List<Payment> payments = service.listPayments();
        return CommonResult.create(200, "来自" + serverPort + payments.size(), payments);
    }

    @RequestMapping("discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(element -> log.info("*****" + element + "*****"));

        List<ServiceInstance> instanceServices = discoveryClient.getInstances("PAYMENT-PRODUCER-SERVER");
        instanceServices.forEach(serviceInstance -> {
            log.info(serviceInstance.getInstanceId() + "\t" + serviceInstance.getHost() + "\t" + serviceInstance.getPort() + "\t" + serviceInstance.getUri());
        });

        return this.discoveryClient;
    }
}
