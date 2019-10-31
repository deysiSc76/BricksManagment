package com.fiuni.sd.bricks_management.service.paymentConcept;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.bricks_management.dao.paymentDetail.IPaymentDetailDao;
import com.fiuni.sd.bricks_management.dao.paymetConcept.IPaymentConceptDao;
import com.fiuni.sd.bricks_management.domain.payment.PaymentDomain;
import com.fiuni.sd.bricks_management.domain.paymentConcept.PaymentConceptDomain;
import com.fiuni.sd.bricks_management.domain.paymentDetail.PaymentDetailDomain;
import com.fiuni.sd.bricks_management.dto.payment.FullPaymentDTO;
import com.fiuni.sd.bricks_management.dto.payment.PaymentDTO;
import com.fiuni.sd.bricks_management.dto.payment.PaymentResult;
import com.fiuni.sd.bricks_management.dto.paymentConcept.FullPaymentConceptDTO;
import com.fiuni.sd.bricks_management.dto.paymentConcept.PaymentConceptDTO;
import com.fiuni.sd.bricks_management.dto.paymentConcept.PaymentConceptResult;
import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailDTO;
import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailResult;
import com.fiuni.sd.bricks_management.service.base.BaseServiceImpl;
import com.fiuni.sd.bricks_management.service.paymentDetail.IPaymentDetailService;

@Service

public class PaymentConceptService extends BaseServiceImpl<PaymentConceptDTO, PaymentConceptDomain, PaymentConceptResult>
implements IPaymentConceptService { 
	@Autowired
	private IPaymentConceptDao paymentConceptDao;
	@Autowired
	private IPaymentDetailService paymentDetailService;
	
	@Override
	@Transactional
	public PaymentDetailDTO save(PaymentDetailDTO dto) {
		final PaymentDetailDomain domain = convertDtoToDomain(dto);
		PaymentDetailDomain paymentDetailDomain = paymentConceptDao.save(domain);
		return convertDomainToDto(paymentDetailDomain);
	}

	@Override
	@Transactional
	public FullPaymentConceptDTO save(FullPaymentConceptDTO fullPayment) {
		fullPayment.setPayment(save(fullPayment.getPayment()));
		fullPayment.getDetails().forEach(
				(PaymentDetailDTO det)->
					det.setPaymentId(fullPayment.getPayment().getId())
		);
		fullPayment.setDetails(
				paymentDetailService.save(fullPayment.getDetails()).getList()
		);
		return fullPayment;
	}
	@Override
	public PaymentConceptDTO getById(Integer id) {
		// nuevo full payment detail dto
		final PaymentConceptDomain domain = paymentConceptDao.findById(id).get();
		return convertDomainToDto(domain);
	}
	@Override
	public PaymentConceptResult getAll(Pageable pageable) {
		final List<PaymentConceptDTO> payments = new ArrayList<>();
		final PaymentConceptResult paymentResult = new PaymentConceptResult();
		paymentResult.setList(payments);
		return paymentResult;
	}
	public void delete(Integer id) {
		paymentConceptDao.deleteById(id);
		
	}
	@Override
	protected PaymentConceptDTO convertDomainToDto(PaymentConceptDomain domain) {
		final PaymentConceptDTO dto = new PaymentConceptDTO();
		dto.setId(domain.getId());
		dto.setName(domain.getName());
		dto.setDescription(domain.getDescription());
		dto.setCost(domain.getCost());
		dto.setBudgetConceptId(domain.get_budgetConceptDetails().getId());
		dto.setMaterial(domain.isMaterial());;
		dto.setProvider(domain.get_provider().getId());;

		
		return dto;
	}
	
	protected FullPaymentConceptDTO convertDomainToFullDto(PaymentConceptDomain domain) {
		final PaymentConceptDTO paymentConceptDto = new PaymentConceptDTO();
		paymentConceptDto.setId(domain.getId());
		paymentConceptDto.setBudgetConceptId(domain.get_budgetConceptDetails().getId());
		paymentConceptDto.setCost(domain.getCost());
		paymentConceptDto.setDescription(domain.getDescription());
		paymentConceptDto.setId(domain.getId());
		paymentConceptDto.setMaterial(domain.isMaterial());
		paymentConceptDto.setName(domain.getName());
		paymentConceptDto.setProvider(domain.get_provider().getId());
		
		FullPaymentConceptDTO dto = new FullPaymentConceptDTO();
		dto.setPayment(paymentConceptDto);		
		dto.setDetails(
			paymentDetailService.getByPaymentId(domain.getId()).getList()
		);		
		
		return dto;
	}

	@Override
	protected PaymentConceptDomain convertDtoToDomain(PaymentConceptDTO dto) {
		final PaymentConceptDomain domain = new PaymentConceptDomain();
		domain.setId(dto.getId());
		domain.setName(dto.getName());
		domain.setCost(domain.getCost());;
		domain.setMaterial(domain.isMaterial());
		return domain;
	}
	
	
}
