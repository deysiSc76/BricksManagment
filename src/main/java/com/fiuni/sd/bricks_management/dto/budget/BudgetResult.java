package com.fiuni.sd.bricks_management.dto.budget;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.dto.base.BaseResult;

@XmlRootElement(name= "budgetResult")
public class BudgetResult extends BaseResult<BudgetDTO>{
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	public List<BudgetDTO> getBudgets() {
		return getList();
	}
	
	public void setBudgets(List<BudgetDTO> dtos) {
		super.setList(dtos);
	}
}
