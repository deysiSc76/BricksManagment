package com.fiuni.sd.bricks_management.dao.payment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.bricks_management.domain.payment.PaymentDomain;

@Repository
public interface IPaymentDAO  extends CrudRepository<PaymentDomain, Integer> {
	
	public Page<PaymentDomain> findAll(Pageable pageable);
	
	public Page<PaymentDomain> findByNumber(Integer number, Pageable pageable);
}
