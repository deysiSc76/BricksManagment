package com.fiuni.sd.bricks_management.dao.paymentConcept;

import java.util.List; 

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.bricks_management.domain.paymentConcept.PaymentConceptDomain;
import com.fiuni.sd.bricks_management.dto.paymentConcept.PaymentConceptDTO;
import com.fiuni.sd.bricks_management.dto.paymentConcept.PaymentConceptResult;

@Repository
public interface IPaymentConceptDao extends CrudRepository<PaymentConceptDomain, Integer> {
	
	public Page<PaymentConceptDomain> findAll(Pageable pageable);

	public Page<PaymentConceptDomain> findByName(String name, Pageable pageable);
	
	public PaymentConceptResult save(List<PaymentConceptDTO> paymentConcepts);
}
