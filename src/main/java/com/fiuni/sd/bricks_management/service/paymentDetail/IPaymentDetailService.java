package com.fiuni.sd.bricks_management.service.paymentDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.bricks_management.dao.payment.PaymentDAO;
import com.fiuni.sd.bricks_management.domain.payment.PaymentDomain;
import com.fiuni.sd.bricks_management.dto.payment.PaymentDTO;
import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailDTO;
import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailResult;
import com.fiuni.sd.bricks_management.dto.provider.ProviderDTO;
import com.fiuni.sd.bricks_management.dto.provider.ProviderResult;
import com.fiuni.sd.bricks_management.service.base.IBaseService;

public interface IPaymentDetailService  extends IBaseService<PaymentDetailDTO,   PaymentDetailResult> {
	@Autowired
	private PaymentDetailDAO paymentDao;
	
	@Override
	@Transactional
	public PaymentDTO save(PaymentDTO dto) {
		final PaymentDomain domain = convertDtoToDomain(dto);
		final PaymentDomain paymentDomain = paymentDao.save(domain);
		return convertDomainToDto(paymentDomain);
	}

}
