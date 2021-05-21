package com.hertz.service.impl;

import com.hertz.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Hertz
 * @date 2021/5/10 20:38
 */
@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String sendOK(Integer id) {
        log.info("线程编号:" + Thread.currentThread().getName() + "; this is payment send OK O(∩_∩)O  request id is:" + id);
        return "线程编号:" + Thread.currentThread().getName() + "; this is payment send OK O(∩_∩)O  request id is:" + id;
    }

    @Override
    @HystrixCommand(fallbackMethod = "sendSomethingCommand", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String sendError(Integer id) {
        int seconds = 4;
        log.info("线程编号:" + Thread.currentThread().getName() + "; this is payment send Error 耗时：" + seconds + "（秒）request id is:" + id);
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程编号:" + Thread.currentThread().getName() + "; this is payment send Error 耗时：" + seconds + "（秒）request id is:" + id;
    }

    public String sendSomethingCommand(Integer id) {
        return "线程编号:" + Thread.currentThread().getName() + "; this is payment sendSomethingCommand (T_T) request id is:" + id;
    }
}
