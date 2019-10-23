package com.fiuni.sd.bricks_management.dto.budgetDetail;

import java.io.Serializable;

public class BudgetDetailDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer amount;
	private Integer quantity;
	private Integer budget_id;
	private Integer budget_concept_id;
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Integer getBudgetId() {
		return budget_id;
	}
	public void setBudgetId(Integer budget_id) {
		this.budget_id = budget_id;
	}
	public int getBudgetConceptId() {
		return budget_concept_id;
	}
	public void setBudgetConceptId(int budget_concept_id) {
		this.budget_concept_id = budget_concept_id;
	}
	
	
}
