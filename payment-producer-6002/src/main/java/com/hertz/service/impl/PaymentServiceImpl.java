package com.hertz.service.impl;

import com.hertz.dao.PaymentDao;
import com.hertz.entities.Payment;
import com.hertz.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hertz
 * @date 2021/5/10 20:38
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentDao dao;

    public PaymentServiceImpl(PaymentDao dao) {
        this.dao = dao;
    }

    @Override
    public long savePayment(Payment payment) {
        return dao.insertPayment(payment);
    }

    @Override
    public List<Payment> listPayments() {
        return dao.listPayments();
    }

    @Override
    public Payment getPaymentById(Long id) {
        return dao.selectPaymentById(id);
    }

}
