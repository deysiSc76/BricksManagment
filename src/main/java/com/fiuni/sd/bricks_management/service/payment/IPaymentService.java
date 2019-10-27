package com.fiuni.sd.bricks_management.service.payment;

import com.fiuni.sd.bricks_management.dto.payment.FullPaymentDTO;
import com.fiuni.sd.bricks_management.dto.payment.PaymentDTO;
import com.fiuni.sd.bricks_management.dto.payment.PaymentResult;

import com.fiuni.sd.bricks_management.service.base.IBaseService;

public interface IPaymentService extends IBaseService<PaymentDTO, PaymentResult> {
	public void delete(Integer id);
	public FullPaymentDTO save(FullPaymentDTO fullPayment);
}
