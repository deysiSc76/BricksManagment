package com.fiuni.sd.bricks_management.dto.paymentConcept;

import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.dto.base.BaseResult;

@XmlRootElement(name = "paymentConceptResult")
public class PaymentConceptResult extends BaseResult<PaymentConceptDTO> {
	private static final long serialVersionUID = 1L;
}
