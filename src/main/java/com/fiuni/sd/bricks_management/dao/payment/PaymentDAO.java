package com.fiuni.sd.bricks_management.dao.payment;

import org.springframework.data.repository.CrudRepository;

import com.fiuni.sd.bricks_management.domain.payment.PaymentDomain;

public interface PaymentDAO  extends CrudRepository<PaymentDomain, Integer> {

}
