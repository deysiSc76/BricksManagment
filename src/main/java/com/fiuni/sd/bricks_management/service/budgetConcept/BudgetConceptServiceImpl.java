package com.fiuni.sd.bricks_management.service.budgetConcept;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fiuni.sd.bricks_management.dao.budgetConcept.IBudgetConceptDAO;
import com.fiuni.sd.bricks_management.domain.budgetConcept.BudgetConceptDomain;
import com.fiuni.sd.bricks_management.domain.paymentConcept.PaymentConceptDomain;
import com.fiuni.sd.bricks_management.dto.budgetConcept.BudgetConceptDTO;
import com.fiuni.sd.bricks_management.dto.budgetConcept.BudgetConceptResult;
import com.fiuni.sd.bricks_management.dto.paymentConcept.PaymentConceptDTO;
import com.fiuni.sd.bricks_management.service.base.BaseServiceImpl;
import com.fiuni.sd.bricks_management.service.budget.BudgetServiceImpl;
import com.fiuni.sd.bricks_management.service.paymentConcept.PaymentConceptService;

@Service
public class BudgetConceptServiceImpl extends BaseServiceImpl<BudgetConceptDTO, 
															  BudgetConceptDomain, 
															  BudgetConceptResult>
	 														  implements IBudgetConceptService {

	@Autowired
	private IBudgetConceptDAO budgetConceptDao;
	@Autowired
	private BudgetServiceImpl budgetService;
	@Autowired
	private PaymentConceptService paymentConceptService;
	
	@Override
	public BudgetConceptDTO save(BudgetConceptDTO dto) {
		final BudgetConceptDomain domain = convertDtoToDomain(dto);
		return convertDomainToDto(budgetConceptDao.save(domain));
	}

	@Override
	public BudgetConceptDTO getById(Integer id) {
		final BudgetConceptDomain domain = budgetConceptDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	public BudgetConceptResult getAll(Pageable pageable) {
		final List<BudgetConceptDTO> dtos = new ArrayList<>();
		final Page<BudgetConceptDomain> domains = budgetConceptDao.findAll(pageable);
		domains.forEach(domain -> dtos.add(convertDomainToDto(domain)));
		BudgetConceptResult budgetConceptResults = new BudgetConceptResult();
		budgetConceptResults.setList(dtos);
		return budgetConceptResults;
	}

	@Override
	protected BudgetConceptDTO convertDomainToDto(BudgetConceptDomain domain) {
		final BudgetConceptDTO dto = new BudgetConceptDTO();
		dto.setId(domain.getId());
		dto.setDescription(domain.getDescription());
		// budget details, domain to dto
		dto.setBudgetDetails(budgetService.convertToDetailDtoList(domain.getBudgetDetails()));
		// payment concepts, domain to dto
		dto.setPaymentConcepts(convertToPaymentDtoList(domain.getPaymentConcepts()));
		
		return dto;
	}
	@Override
	public void delete(Integer id) {
		budgetConceptDao.deleteById(id);
		
	}


	@Override
	protected BudgetConceptDomain convertDtoToDomain(BudgetConceptDTO dto) {
		final BudgetConceptDomain domain = new BudgetConceptDomain();
		// budget details, dto to domain
		domain.setBudgetDetails(budgetService.convertToDetailDomainList(dto.getBudgetDetails()));
		domain.setDescription(dto.getDescription());
		domain.setId(dto.getId());
		// payment concepts, dto to domain
		domain.setPaymentConcepts(convertToPaymentDomainList(dto.getPaymentConcepts()));
		
		return domain;
	}
	
	public List<PaymentConceptDomain> convertToPaymentDomainList(List<PaymentConceptDTO> list){
		final ArrayList<PaymentConceptDomain> domains = new ArrayList<>();
		list.forEach( dto -> domains.add( paymentConceptService.convertDtoToDomain(dto) ) );
		return domains;
	}

	public List<PaymentConceptDTO> convertToPaymentDtoList(List<PaymentConceptDomain> list){
		final ArrayList<PaymentConceptDTO> dtos = new ArrayList<>();
		list.forEach( domain -> dtos.add( paymentConceptService.convertDomainToDto(domain) ) );
		return dtos;
	}

	@Override
	public BudgetConceptDTO update(Integer id, BudgetConceptDTO dto) {
		BudgetConceptDTO toUpdate = new BudgetConceptDTO();
		toUpdate.setBudgetDetails(dto.getBudgetDetails());
		toUpdate.setDescription(dto.getDescription());
		toUpdate.setPaymentConcepts(dto.getPaymentConcepts());
		
		return toUpdate;
	}
}
