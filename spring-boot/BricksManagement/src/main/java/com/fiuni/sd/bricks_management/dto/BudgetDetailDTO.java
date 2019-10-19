package com.fiuni.sd.bricks_management.dto;

import java.io.Serializable;

public class BudgetDetailDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	int amount;
	int quantity;
	int budgetConceptId;
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
	public int getBudgetConceptId() {
		return budgetConceptId;
	}
	public void setBudgetConceptId(int budgetConceptId) {
		this.budgetConceptId = budgetConceptId;
	}
	
	
}
