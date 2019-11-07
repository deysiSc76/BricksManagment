package com.fiuni.sd.bricks_management.service.payment;

import org.springframework.data.domain.Pageable;

import com.fiuni.sd.bricks_management.dto.payment.PaymentDTO;
import com.fiuni.sd.bricks_management.dto.payment.PaymentResult;
import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailDTO;
import com.fiuni.sd.bricks_management.service.base.IBaseService;

public interface IPaymentService extends IBaseService<PaymentDTO, PaymentResult> {
	
	public void delete(Integer id);
	
	public void deleteDetail(Integer id);
	
	public PaymentDTO update(Integer id, PaymentDTO payment);
	
	public PaymentDetailDTO updateDetail(Integer id, PaymentDetailDTO paymentDetail);
	
	public PaymentResult getByNumber(int number, Pageable pageable);
}
