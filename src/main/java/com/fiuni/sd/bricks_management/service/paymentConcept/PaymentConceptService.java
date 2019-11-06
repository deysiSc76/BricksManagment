package com.fiuni.sd.bricks_management.service.paymentConcept;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.bricks_management.dao.budgetConcept.IBudgetConceptDAO;
import com.fiuni.sd.bricks_management.dao.paymentConcept.IPaymentConceptDao;
import com.fiuni.sd.bricks_management.dao.providers.IProviderDao;
import com.fiuni.sd.bricks_management.domain.paymentConcept.PaymentConceptDomain;
import com.fiuni.sd.bricks_management.dto.paymentConcept.PaymentConceptDTO;
import com.fiuni.sd.bricks_management.dto.paymentConcept.PaymentConceptResult;
import com.fiuni.sd.bricks_management.service.base.BaseServiceImpl;
import com.fiuni.sd.bricks_management.service.payment.PaymentServiceImpl;

@Service

public class PaymentConceptService extends BaseServiceImpl<PaymentConceptDTO, PaymentConceptDomain, PaymentConceptResult>
implements IPaymentConceptService { 
	
	@Autowired
	private IPaymentConceptDao paymentConceptDao;
	@Autowired
	private IBudgetConceptDAO budgetConceptDao;
	@Autowired
	private IProviderDao providerDao;
	@Autowired
	private PaymentServiceImpl paymentService;
	
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
		return convertDomainToDto(paymentConceptDao.findById(id).get());
	}
	@Override
	public PaymentConceptResult getAll(Pageable pageable) {
		final List<PaymentConceptDTO> paymentConcepts = new ArrayList<>();
		Page<PaymentConceptDomain> results = paymentConceptDao.findAll(pageable);
		results.forEach(paymentConcept -> paymentConcepts.add(convertDomainToDto(paymentConcept)));
		
		final PaymentConceptResult paymentConceptResults = new PaymentConceptResult();
		paymentConceptResults.setList(paymentConcepts);
		return paymentConceptResults;
	}
	
	@Override
	public PaymentConceptResult getByName(String name, Pageable pageable) {
		final List<PaymentConceptDTO> paymentConcepts = new ArrayList<>();
		Page<PaymentConceptDomain> results = paymentConceptDao.findByName(name, pageable);
		results.forEach(paymentConcept -> paymentConcepts.add(convertDomainToDto(paymentConcept)));
		
		final PaymentConceptResult paymentConceptResults = new PaymentConceptResult();
		paymentConceptResults.setList(paymentConcepts);
		return paymentConceptResults;
	}
	
	public void delete(Integer id) {
		paymentConceptDao.deleteById(id);
		
	}
	@Override
	public PaymentConceptDTO convertDomainToDto(PaymentConceptDomain domain) {
		final PaymentConceptDTO dto = new PaymentConceptDTO();
		/*dto.setId(domain.getId());
		dto.setName(domain.getName());
		dto.setDescription(domain.getDescription());
		dto.setCost(domain.getCost());
		dto.setBudgetConceptId(domain.get_budgetConcept().getId());
		dto.setMaterial(domain.isMaterial());;
		dto.setProvider(domain.get_provider().getId());;
		dto.setPaymentDetails(paymentService.convertToPaymentDetailDtoList(domain.get_paymentDetails()));*/
		
		return dto;
	}

	@Override
	public PaymentConceptDomain convertDtoToDomain(PaymentConceptDTO dto) {
		final PaymentConceptDomain domain = new PaymentConceptDomain();
		/*domain.setId(dto.getId());
		domain.setName(dto.getName());
		domain.setCost(domain.getCost());
		domain.setMaterial(domain.isMaterial());
		domain.set_budgetConcept(budgetConceptDao.findById(dto.getBudgetConceptId()).get());
		domain.set_paymentDetails(paymentService.convertToPaymentDetailDomainList(dto.getPaymentDetails()));
		domain.set_provider(providerDao.findById(dto.getProviderId()).get());*/
		
		return domain;
	}

}
