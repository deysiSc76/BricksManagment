package com.fiuni.sd.bricks_management.dto.payment;

import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.dto.base.BaseResult;


@XmlRootElement(name = "paymentResult")
public class PaymentResult extends BaseResult<PaymentDTO> {
	private static final long serialVersionUID = 1L;

}
