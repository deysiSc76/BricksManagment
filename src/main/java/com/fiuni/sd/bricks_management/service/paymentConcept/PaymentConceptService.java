package com.fiuni.sd.bricks_management.service.paymentConcept;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.bricks_management.dao.paymentConcept.IPaymentConceptDao;
import com.fiuni.sd.bricks_management.domain.paymentConcept.PaymentConceptDomain;
import com.fiuni.sd.bricks_management.dto.paymentConcept.PaymentConceptDTO;
import com.fiuni.sd.bricks_management.dto.paymentConcept.PaymentConceptResult;
import com.fiuni.sd.bricks_management.service.base.BaseServiceImpl;

@Service

public class PaymentConceptService extends BaseServiceImpl<PaymentConceptDTO, PaymentConceptDomain, PaymentConceptResult>
implements IPaymentConceptService { 
	@Autowired
	private IPaymentConceptDao paymentConceptDao;
	
	@Override
	@Transactional
	public PaymentConceptDTO save(PaymentConceptDTO dto) {
		final PaymentConceptDomain domain = convertDtoToDomain(dto);
		PaymentConceptDomain paymentDetailDomain = paymentConceptDao.save(domain);
		return convertDomainToDto(paymentDetailDomain);
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
