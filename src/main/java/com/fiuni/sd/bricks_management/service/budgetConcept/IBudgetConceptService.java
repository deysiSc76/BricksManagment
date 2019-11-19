package com.fiuni.sd.bricks_management.service.budgetConcept;

import org.springframework.stereotype.Service;

import com.fiuni.sd.bricks_management.dto.budgetConcept.BudgetConceptDTO;
import com.fiuni.sd.bricks_management.dto.budgetConcept.BudgetConceptResult;
import com.fiuni.sd.bricks_management.service.base.IBaseService;

@Service
public interface IBudgetConceptService extends IBaseService<BudgetConceptDTO, BudgetConceptResult> {
	
	public BudgetConceptDTO update(Integer id, BudgetConceptDTO dto);
	public void delete(Integer id);
	
}
