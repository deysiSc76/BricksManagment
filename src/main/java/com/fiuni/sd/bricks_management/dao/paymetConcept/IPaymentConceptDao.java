package com.fiuni.sd.bricks_management.dao.paymetConcept;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.fiuni.sd.bricks_management.domain.paymentConcept.PaymentConceptDomain;

public interface IPaymentConceptDao extends CrudRepository<PaymentConceptDomain, Integer> {
	public Page<PaymentConceptDomain> findAll(Pageable pageable);
}
