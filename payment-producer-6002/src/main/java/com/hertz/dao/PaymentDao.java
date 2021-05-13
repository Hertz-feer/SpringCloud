package com.hertz.dao;

import com.hertz.entities.Payment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Hertz
 * @date 2021/5/10 15:33
 */
@Repository
public class PaymentDao {

    private List<Payment> db = new ArrayList<>();

    private Long maxPaymentIdIndex = 6L;

    {
        db.add(new Payment(1L, UUID.randomUUID().toString()));
        db.add(new Payment(2L, UUID.randomUUID().toString()));
        db.add(new Payment(3L, UUID.randomUUID().toString()));
        db.add(new Payment(4L, UUID.randomUUID().toString()));
        db.add(new Payment(5L, UUID.randomUUID().toString()));
        db.add(new Payment(6L, UUID.randomUUID().toString()));
    }

    public long insertPayment(Payment payment) {
        payment.setId(++maxPaymentIdIndex);
        db.add(payment);
        return payment.getId();
    }

    public Payment selectPaymentById(Long id) {
        if (Objects.isNull(id)) {
            return null;
        } else {
            for (Payment pa : db) {
                if (Objects.equals(pa.getId(), id)) {
                    return pa;
                }
            }
        }
        return null;
    }

    public List<Payment> listPayments() {
        return db;
    }

}
