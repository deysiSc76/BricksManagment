package com.fiuni.sd.bricks_management.dto.budget;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import com.fiuni.sd.bricks_management.dto.budgetDetail.BudgetDetailDTO;


@XmlRootElement(name = "budget")
public class FullBudgetDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private BudgetDTO budget;
	private List<BudgetDetailDTO> details;
	
	public BudgetDTO getBudget() {
		return budget;
	}
	public void setBudget(BudgetDTO budget) {
		this.budget = budget;
	}
	public List<BudgetDetailDTO> getDetais() {
		return details;
	}
	public void setDetails(List<BudgetDetailDTO> details) {
		this.details = details;
	}
	public int getTotalDetails() {
		return details != null ? details.size() : 0;
	}

}
