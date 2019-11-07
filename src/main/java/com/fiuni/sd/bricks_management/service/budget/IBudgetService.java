package com.fiuni.sd.bricks_management.service.budget;

import org.springframework.stereotype.Service;

import com.fiuni.sd.bricks_management.dto.budget.BudgetDTO;
import com.fiuni.sd.bricks_management.dto.budget.BudgetResult;
import com.fiuni.sd.bricks_management.dto.budgetDetail.BudgetDetailDTO;
import com.fiuni.sd.bricks_management.service.base.IBaseService;

@Service
public interface IBudgetService extends IBaseService<BudgetDTO,BudgetResult>{
	
	public void delete(Integer id);
	
	public void deleteDetail(Integer id);
	
	public BudgetDTO update(BudgetDTO dto, Integer id);
	
	public BudgetDetailDTO updateDetail(Integer id, BudgetDetailDTO detail);
}
