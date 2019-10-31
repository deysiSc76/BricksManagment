package com.fiuni.sd.bricks_management.service.paymentConcept;

import java.util.List;

import com.fiuni.sd.bricks_management.dto.payment.FullPaymentDTO;
import com.fiuni.sd.bricks_management.dto.paymentConcept.FullPaymentConceptDTO;
import com.fiuni.sd.bricks_management.dto.paymentConcept.PaymentConceptDTO;
import com.fiuni.sd.bricks_management.dto.paymentConcept.PaymentConceptResult;
import com.fiuni.sd.bricks_management.service.base.IBaseService;

public interface IPaymentConceptService extends IBaseService<PaymentConceptDTO, PaymentConceptResult> {
	public void delete(Integer id);
	public FullPaymentConceptDTO save(FullPaymentConceptDTO fullPaymentConcept);
}
