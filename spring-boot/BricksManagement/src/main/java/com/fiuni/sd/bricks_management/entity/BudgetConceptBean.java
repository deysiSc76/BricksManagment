package com.fiuni.sd.bricks_management.entity;

import java.io.Serializable;
import java.util.List;

public class BudgetConceptBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String description;
	List<BudgetDetailBean> budget_details;
	List<PaymentConceptBean> payment_concepts;
	
	// ***********************************************************************
	
	// GETTERS & SETTERS
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<BudgetDetailBean> getBudgetDetails() {
		return budget_details;
	}
	public void setBudgetDetails(List<BudgetDetailBean> budget_details) {
		this.budget_details = budget_details;
	}
	public List<PaymentConceptBean> getPayment_concepts() {
		return payment_concepts;
	}
	public void setPaymentConcepts(List<PaymentConceptBean> payment_concepts) {
		this.payment_concepts = payment_concepts;
	}
	
	// ***********************************************************************
	
}
