package com.hertz.service;

import com.hertz.entities.Payment;

import java.util.List;

/**
 * @author Hertz
 * @date 2021/5/10 20:36
 */
public interface PaymentService {

    long savePayment(Payment payment);

    List<Payment> listPayments();

    Payment getPaymentById(Long id);
}
