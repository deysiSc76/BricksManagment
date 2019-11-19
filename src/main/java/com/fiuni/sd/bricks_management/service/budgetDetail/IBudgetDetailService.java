package com.fiuni.sd.bricks_management.service.budgetDetail;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fiuni.sd.bricks_management.dto.base.BaseResult;
import com.fiuni.sd.bricks_management.dto.budget.BudgetDTO;
import com.fiuni.sd.bricks_management.dto.budgetDetail.BudgetDetailDTO;
import com.fiuni.sd.bricks_management.dto.budgetDetail.BudgetDetailResult;
import com.fiuni.sd.bricks_management.service.base.IBaseService;

@Service
public interface IBudgetDetailService extends IBaseService<BudgetDetailDTO, BudgetDetailResult> {
	public BudgetDetailResult getByBudgetId(Integer budgetId);
	public BudgetDetailDTO update(Integer id, BudgetDetailDTO dto);
	public BudgetDetailResult saveList(List<BudgetDetailDTO> budgetDetails);
	public void delete(Integer id);
	
}
