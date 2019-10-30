package com.fiuni.sd.bricks_management.dto.budgetDetail;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.dto.base.BaseResult;

@XmlRootElement(name= "budgetDetailResult")
public class BudgetDetailResult extends BaseResult<BudgetDetailDTO> {
private static final long serialVersionUID = 1L;
	
	@XmlElement
	public List<BudgetDetailDTO> getBudgets() {
		return getList();
	}
	
	public void setCharges(List<BudgetDetailDTO> dtos) {
		super.setList(dtos);
	}
}
