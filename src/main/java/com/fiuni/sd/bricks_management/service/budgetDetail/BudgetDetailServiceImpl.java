package com.fiuni.sd.bricks_management.service.budgetDetail;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.bricks_management.dao.budget.IBudgetDAO;
import com.fiuni.sd.bricks_management.dao.budgetConcept.IBudgetConceptDAO;
import com.fiuni.sd.bricks_management.dao.budgetDetail.IBudgetDetailDAO;
import com.fiuni.sd.bricks_management.domain.budgetDetail.BudgetDetailDomain;
import com.fiuni.sd.bricks_management.domain.paymentDetail.PaymentDetailDomain;
import com.fiuni.sd.bricks_management.dto.budgetDetail.BudgetDetailDTO;
import com.fiuni.sd.bricks_management.dto.budgetDetail.BudgetDetailResult;
import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailDTO;
import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailResult;
import com.fiuni.sd.bricks_management.service.base.BaseServiceImpl;

@Service
public class BudgetDetailServiceImpl extends BaseServiceImpl<BudgetDetailDTO, BudgetDetailDomain, BudgetDetailResult> 
	implements IBudgetDetailService {

	@Autowired
	private IBudgetDetailDAO budgetDetailDao;
	@Autowired
	private IBudgetDAO budgetDao;
	@Autowired
	private IBudgetConceptDAO budgetConceptDao;
	
	

	@Override
	public BudgetDetailDTO getById(Integer id) {
		return convertDomainToDto(budgetDetailDao.findById(id).get());
	}

	@Override
	public BudgetDetailResult getAll(Pageable pageable) {
		final List<BudgetDetailDTO> dtos = new ArrayList<>();
		Page<BudgetDetailDomain> resultDomains = budgetDetailDao.findAll(pageable);
		resultDomains.forEach(domain -> dtos.add(convertDomainToDto(domain)));
		final BudgetDetailResult budgetDetailResult = new BudgetDetailResult();
		budgetDetailResult.setBudgetDetails(dtos);
		return budgetDetailResult;
	}

	@Override
	public BudgetDetailDTO update(Integer id, BudgetDetailDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected BudgetDetailDTO convertDomainToDto(BudgetDetailDomain domain) {
		final BudgetDetailDTO dto = new BudgetDetailDTO();
		dto.setId(domain.getId());
		dto.setAmount(domain.getAmount());
		dto.setQuantity(domain.getQuantity());
		dto.setBudgetConceptId(domain.getBudgetConcept().getId());
		//dto.setBudgetId(domain.getBudget().getId());
		return dto;
	}

	protected BudgetDetailDomain convertDtoToDomain(BudgetDetailDTO dto, Integer budgetId) {
		final BudgetDetailDomain domain = new BudgetDetailDomain();
		domain.setAmount(dto.getAmount());
		domain.setBudget(budgetDao.findById(budgetId).get());
		domain.setBudgetConcept(budgetConceptDao.findById(dto.getBudgetConceptId()).get());
		domain.setId(dto.getId());
		domain.setQuantity(dto.getQuantity());
		
		return domain;
	}
	
	@Override
	protected BudgetDetailDomain convertDtoToDomain(BudgetDetailDTO dto) {
		final BudgetDetailDomain domain = new BudgetDetailDomain();
		domain.setId(dto.getId());
		domain.setAmount(dto.getAmount());
		domain.setBudget(budgetDao.findById(dto.getBudgetId()).get());
		domain.setBudgetConcept(budgetConceptDao.findById(dto.getBudgetConceptId()).get());
		domain.setQuantity(dto.getQuantity());
		return null;
	}

	public List<BudgetDetailDomain> convertToDetailDomainList(List<BudgetDetailDTO> list, Integer budgetId){
		final ArrayList<BudgetDetailDomain> domains = new ArrayList<>();
		list.forEach( dto -> domains.add( convertDtoToDomain(dto, budgetId) ) );
		return domains;
	}

	public List<BudgetDetailDTO> convertToDetailDtoList(List<BudgetDetailDomain> list){
		final ArrayList<BudgetDetailDTO> dtos = new ArrayList<>();
		list.forEach( domain -> dtos.add( convertDomainToDto( domain ) ) );
		return dtos;
	}
	
	@Override
	@Transactional
	public BudgetDetailResult saveList(List<BudgetDetailDTO> budgetDetails) {
		for(BudgetDetailDTO dto : budgetDetails) {
			BudgetDetailDTO saved = save(dto);
			dto.setId(saved.getId());
		}
		BudgetDetailResult budgetDetailResult = new BudgetDetailResult();
		budgetDetailResult.setList(budgetDetails);
		return budgetDetailResult;
	}
	@Override
	public BudgetDetailResult getByBudgetId(Integer budgetId) {
		final List<BudgetDetailDTO> budgetDetails = new ArrayList<>();
		List<BudgetDetailDomain> results = budgetDetailDao.findByBudgetId(budgetId);
		results.forEach(budgetDetail -> budgetDetails.add(convertDomainToDto(budgetDetail)));
		
		final BudgetDetailResult budgetDetailResult = new BudgetDetailResult();
		budgetDetailResult.setList(budgetDetails);
		return budgetDetailResult;
	}
	@Override
	public void delete(Integer id) {
		budgetDao.deleteById(id);
		
	}

	@Override
	public BudgetDetailDTO save(BudgetDetailDTO dto) {
		BudgetDetailDomain newDet =  budgetDetailDao.save(convertDtoToDomain(dto));
		return convertDomainToDto(newDet);
	}
	
}
