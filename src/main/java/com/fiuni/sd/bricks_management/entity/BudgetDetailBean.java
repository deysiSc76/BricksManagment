package com.fiuni.sd.bricks_management.entity;

import java.io.Serializable;

public class BudgetDetailBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	int amount;
	int quantity;
	BudgetBean budget;
	BudgetConceptBean budget_concept;
	
	// ***********************************************************************
	
	// GETTERS & SETTERS
	
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
	public BudgetBean getBudget() {
		return budget;
	}
	public void setBudget(BudgetBean budget) {
		this.budget = budget;
	}
	public BudgetConceptBean getBudgetConcept() {
		return budget_concept;
	}
	public void setBudgetConcept(BudgetConceptBean budget_concept) {
		this.budget_concept = budget_concept;
	}
	
	// ***********************************************************************
	
}
