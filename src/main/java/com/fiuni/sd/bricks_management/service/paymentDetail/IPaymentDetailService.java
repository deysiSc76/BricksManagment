package com.fiuni.sd.bricks_management.service.paymentDetail;

import java.util.List;

import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailDTO;
import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailResult;
import com.fiuni.sd.bricks_management.service.base.IBaseService;

public interface IPaymentDetailService  extends IBaseService<PaymentDetailDTO,   PaymentDetailResult> {

	public PaymentDetailResult getByPaymentId(Integer paymentId);
	public PaymentDetailResult save(List<PaymentDetailDTO> paymentDetails);
	public void delete(PaymentDetailDTO detail);
}
