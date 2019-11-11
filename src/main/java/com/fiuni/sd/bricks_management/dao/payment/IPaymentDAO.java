package com.fiuni.sd.bricks_management.dao.payment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.fiuni.sd.bricks_management.domain.payment.PaymentDomain;
import com.fiuni.sd.bricks_management.domain.paymentDetail.PaymentDetailDomain;

public interface IPaymentDAO  extends CrudRepository<PaymentDomain, Integer> {
	public Page<PaymentDetailDomain> findAll(Pageable pageable);
}