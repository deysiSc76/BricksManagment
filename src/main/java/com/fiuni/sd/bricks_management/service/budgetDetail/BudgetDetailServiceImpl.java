package com.fiuni.sd.bricks_management.service.budgetDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fiuni.sd.bricks_management.dao.budget.IBudgetDAO;
import com.fiuni.sd.bricks_management.dao.budgetConcept.IBudgetConceptDAO;
import com.fiuni.sd.bricks_management.dao.budgetDetail.IBudgetDetailDAO;
import com.fiuni.sd.bricks_management.domain.budgetDetail.BudgetDetailDomain;
import com.fiuni.sd.bricks_management.dto.budgetDetail.BudgetDetailDTO;
import com.fiuni.sd.bricks_management.dto.budgetDetail.BudgetDetailResult;
import com.fiuni.sd.bricks_management.service.base.BaseServiceImpl;

@Service
public class BudgetDetailServiceImpl extends BaseServiceImpl<BudgetDetailDTO,BudgetDetailDomain,BudgetDetailResult>
	implements IBudgetDetailService{
	
	@Autowired
	private IBudgetDAO budgetDao;
	@Autowired
	private IBudgetConceptDAO budgetConceptDao;
	@Autowired
	private IBudgetDetailDAO budgetDetailDao;
	
	@Override
	public BudgetDetailDTO save(BudgetDetailDTO dto) {
		BudgetDetailDomain domain = convertDtoToDomain(dto);
		return convertDomainToDto(budgetDetailDao.save(domain));
	}
	
	
	@Override
	public BudgetDetailDTO getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BudgetDetailResult getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected BudgetDetailDTO convertDomainToDto(BudgetDetailDomain domain) {
		BudgetDetailDTO dto = new BudgetDetailDTO();
		dto.setAmount(domain.getAmount());
		dto.setBudgetConceptId(domain.getBudgetConcept().getId());
		dto.setBudgetId(domain.getBudget().getId());
		dto.setId(domain.getId());
		dto.setQuantity(domain.getQuantity());
		return dto;
	}

	@Override
	protected BudgetDetailDomain convertDtoToDomain(BudgetDetailDTO dto) {
		BudgetDetailDomain domain = new BudgetDetailDomain();
		domain.setAmount(dto.getAmount());
		domain.setBudget(budgetDao.findById(dto.getBudgetId()).get());
		domain.setBudgetConcept(budgetConceptDao.findById(dto.getBudgetConceptId()).get());
		domain.setId(dto.getId());
		domain.setQuantity(dto.getQuantity());
		return domain;
	}

}
