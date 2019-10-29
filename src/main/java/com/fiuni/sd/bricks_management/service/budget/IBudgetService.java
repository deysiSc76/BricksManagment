package com.fiuni.sd.bricks_management.service.budget;

import org.springframework.stereotype.Service;

import com.fiuni.sd.bricks_management.dto.budget.BudgetDTO;
import com.fiuni.sd.bricks_management.dto.budget.BudgetResult;
import com.fiuni.sd.bricks_management.service.base.IBaseService;

@Service
public interface IBudgetService extends IBaseService<BudgetDTO,BudgetResult>{
	
}
