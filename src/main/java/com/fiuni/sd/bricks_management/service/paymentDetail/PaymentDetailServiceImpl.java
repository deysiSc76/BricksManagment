package com.fiuni.sd.bricks_management.service.paymentDetail;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.bricks_management.dao.payment.IPaymentDAO;
import com.fiuni.sd.bricks_management.dao.paymentConcept.IPaymentConceptDao;
import com.fiuni.sd.bricks_management.dao.paymentDetail.IPaymentDetailDao;
import com.fiuni.sd.bricks_management.domain.paymentDetail.PaymentDetailDomain;
import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailDTO;
import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailResult;
import com.fiuni.sd.bricks_management.service.base.BaseServiceImpl;

@Service
public class PaymentDetailServiceImpl  extends BaseServiceImpl<PaymentDetailDTO, PaymentDetailDomain, PaymentDetailResult>
implements IPaymentDetailService {

	@Autowired
	private IPaymentDetailDao paymentDetailDao;
	@Autowired
	private IPaymentDAO paymentDAO;
	@Autowired
	private IPaymentConceptDao paymentConceptDAO;
	
	@Override
	@Transactional
	public PaymentDetailDTO save(PaymentDetailDTO dto) {
		final PaymentDetailDomain domain = convertDtoToDomain(dto);
		PaymentDetailDomain paymentDetailDomain = paymentDetailDao.save(domain);
		return convertDomainToDto(paymentDetailDomain);
	}
	
	@Override
	@Transactional
	public PaymentDetailResult save(List<PaymentDetailDTO> paymentDetails) {
		for(PaymentDetailDTO dto : paymentDetails) {
			PaymentDetailDTO saved = save(dto);
			dto.setId(saved.getId());
		}
		PaymentDetailResult paymentDetailResult = new PaymentDetailResult();
		paymentDetailResult.setList(paymentDetails);
		return paymentDetailResult;
	}
	
	@Override
	public PaymentDetailResult getByPaymentId(Integer paymentId) {
		final List<PaymentDetailDTO> paymentDetails = new ArrayList<>();
		List<PaymentDetailDomain> results = paymentDetailDao.findByPaymentId(paymentId);
		results.forEach(paymentDetail -> paymentDetails.add(convertDomainToDto(paymentDetail)));
		
		final PaymentDetailResult paymentDetailResult = new PaymentDetailResult();
		paymentDetailResult.setList(paymentDetails);
		return paymentDetailResult;
	}
	
	@Override
	public PaymentDetailDTO getById(Integer id) {
		final PaymentDetailDomain domain = paymentDetailDao.findById(id).get();
		return convertDomainToDto(domain);
	}
	
	@Override
	public PaymentDetailResult getAll(Pageable pageable) {
		final List<PaymentDetailDTO> paymentDetails = new ArrayList<>();
		Page<PaymentDetailDomain> results = paymentDetailDao.findAll(pageable);
		results.forEach(paymentDetail -> paymentDetails.add(convertDomainToDto(paymentDetail)));
		
		final PaymentDetailResult paymentDetailResult = new PaymentDetailResult();
		paymentDetailResult.setList(paymentDetails);
		return paymentDetailResult;
	}


	@Override
	public void delete(PaymentDetailDTO detail) {
		paymentDetailDao.deleteById(detail.getId());	
	}
	
	@Override
	protected PaymentDetailDTO convertDomainToDto(PaymentDetailDomain domain) {
		final PaymentDetailDTO dto = new PaymentDetailDTO();
		dto.setId(domain.getId());
		dto.setUnitPrice(domain.getUnit_price());
		dto.setQuantity(domain.getQuantity());
		dto.setPaymentRelatedId(domain.getPayment_related().getId());
		dto.setPaymentConcept(domain.getPayment_concept().getId());
		dto.setPaymentId(domain.getPayment().getId());
		return dto;
	}
	
	
	@Override
	protected PaymentDetailDomain convertDtoToDomain(PaymentDetailDTO dto) {
		final PaymentDetailDomain domain = new PaymentDetailDomain();
		domain.setId(dto.getId());
		domain.setUnit_price(dto.getUnitPrice());
		domain.setQuantity(dto.getQuantity());
		domain.setPayment(paymentDAO.findById(dto.getPaymentId()).get());
		domain.setPayment_concept(paymentConceptDAO.findById(dto.getPaymentConceptId()).orElse(null));
		domain.setPayment_related(paymentDAO.findById(dto.getPaymentRelatedId()).orElse(null));
		return domain;
	}

}
