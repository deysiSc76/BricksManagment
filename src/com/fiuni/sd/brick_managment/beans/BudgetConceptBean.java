package com.fiuni.sd.brick_managment.beans;

import java.io.Serializable;
import java.util.List;

public class BudgetConceptBean implements Serializable {
	private static final long serialVersionUID = 1L;
	String description;
	List<BudgetDetailBean> budgetDetails;
	List<PaymentConceptBean> paymentConcepts;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<BudgetDetailBean> getBudgetDetails() {
		return budgetDetails;
	}
	public void setBudgetDetails(List<BudgetDetailBean> budgetDetails) {
		this.budgetDetails = budgetDetails;
	}
	public List<PaymentConceptBean> getPaymentConcepts() {
		return paymentConcepts;
	}
	public void setPaymentConcepts(List<PaymentConceptBean> paymentConcepts) {
		this.paymentConcepts = paymentConcepts;
	}
	
	

}
