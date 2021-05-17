package com.hertz.controller;

import com.hertz.entities.CommonResult;
import com.hertz.entities.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Hertz
 * @date 2021/5/12 10:33
 */
@RestController
@RequestMapping("payment/consumer")
public class PaymentConsumerController {

    private final RestTemplate restTemplate;

    private static final String PAYMENT_PRODUCER_URL = "http://PAYMENT-PRODUCER-SERVER/payment/";

    public PaymentConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("save")
    public CommonResult savePayment(Payment payment) {
        CommonResult commonResult = restTemplate.postForObject(PAYMENT_PRODUCER_URL + "save", payment, CommonResult.class);
        return commonResult;
    }

    @RequestMapping("list")
    public CommonResult listPayments() {
        CommonResult commonResult = restTemplate.postForObject(PAYMENT_PRODUCER_URL + "list", null, CommonResult.class);
        return commonResult;
    }

    @RequestMapping("get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        CommonResult commonResult = restTemplate.getForObject(PAYMENT_PRODUCER_URL + "get/" + id, CommonResult.class);
        return commonResult;
    }

    @RequestMapping("list/entity")
    public CommonResult listPaymentByEntity() {
        ResponseEntity<CommonResult> responseEntity = restTemplate.postForEntity(PAYMENT_PRODUCER_URL + "list", null, CommonResult.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            return CommonResult.create(400, "调用失败");
        }
    }

}
