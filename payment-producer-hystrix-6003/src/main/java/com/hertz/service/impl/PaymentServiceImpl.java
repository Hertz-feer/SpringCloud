package com.hertz.service.impl;

import cn.hutool.core.util.IdUtil;
import com.hertz.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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


    @HystrixCommand(fallbackMethod = "sendErrorFallBack", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
    })
    public String sendErrorById(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能小于0");
        } else {
            String s = IdUtil.simpleUUID();
            return Thread.currentThread().getName() + "\t 调用流水号：" + s;
        }
    }

    public String sendErrorFallBack(Integer id) {
        return "id 不能小于O /(ㄒoㄒ)/~~";
    }
}
