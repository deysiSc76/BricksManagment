package com.fiuni.sd.bricks_management.service.paymentDetail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.bricks_management.dao.payment.IPaymentDAO;
import com.fiuni.sd.bricks_management.dao.paymentDetail.IPaymentDetailDao;
import com.fiuni.sd.bricks_management.domain.payment.PaymentDomain;
import com.fiuni.sd.bricks_management.dto.payment.PaymentDTO;
import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailDTO;
import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailResult;
import com.fiuni.sd.bricks_management.dto.provider.ProviderDTO;
import com.fiuni.sd.bricks_management.dto.provider.ProviderResult;
import com.fiuni.sd.bricks_management.service.base.IBaseService;

public interface IPaymentDetailService  extends IBaseService<PaymentDetailDTO,   PaymentDetailResult> {

	public PaymentDetailResult getByPaymentId(Integer paymentId);
	public PaymentDetailResult save(List<PaymentDetailDTO> paymentDetails);
	public void delete(PaymentDetailDTO detail);
}
