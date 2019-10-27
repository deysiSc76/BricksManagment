package com.fiuni.sd.bricks_management.dao.paymentConcept;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.fiuni.sd.bricks_management.domain.paymentConcept.PaymentConceptDomain;
import com.fiuni.sd.bricks_management.domain.paymentDetail.PaymentDetailDomain;

public interface IPaymentConceptDao extends CrudRepository<PaymentConceptDomain, Integer> {
	public Page<PaymentDetailDomain> findAll(Pageable pageable);

}
