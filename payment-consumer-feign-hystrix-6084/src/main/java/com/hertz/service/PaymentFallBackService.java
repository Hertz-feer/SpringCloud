package com.hertz.service;

import org.springframework.stereotype.Component;

/**
 * @author Hertz
 * @date 2021/5/20 17:53
 */
@Component
public class PaymentFallBackService implements PaymentService {

    @Override
    public String sendOK(Integer id) {
        return "---- this is PaymentFallBackService fall back function , sendOK , but now is error /(ㄒoㄒ)/~~";
    }

    @Override
    public String sendError(Integer id) {
        return "---- this is PaymentFallBackService fall back function , sendError , now is error /(ㄒoㄒ)/~~";
    }
}
