package com.fiuni.sd.brick_managment.beans;

import java.io.Serializable;

public class BudgetDetailBean implements Serializable {
	private static final long serialVersionUID = 1L;
	int amount;
	int quantity;
	BudgetConceptBean budgetConcept;
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
	public BudgetConceptBean getBudgetConcept() {
		return budgetConcept;
	}
	public void setBudgetConcept(BudgetConceptBean budgetConcept) {
		this.budgetConcept = budgetConcept;
	}
	
	
}
