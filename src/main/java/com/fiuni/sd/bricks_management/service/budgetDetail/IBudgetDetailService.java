package com.fiuni.sd.bricks_management.service.budgetDetail;

import org.springframework.stereotype.Service;

import com.fiuni.sd.bricks_management.dto.budgetDetail.BudgetDetailDTO;
import com.fiuni.sd.bricks_management.dto.budgetDetail.BudgetDetailResult;
import com.fiuni.sd.bricks_management.service.base.IBaseService;

@Service
public interface IBudgetDetailService extends IBaseService<BudgetDetailDTO, BudgetDetailResult> {
	
	public BudgetDetailDTO update(Integer id, BudgetDetailDTO dto);
	
	public void delete(Integer id);
	
}
