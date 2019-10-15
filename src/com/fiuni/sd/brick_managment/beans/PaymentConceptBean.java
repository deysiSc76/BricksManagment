package com.fiuni.sd.brick_managment.beans;

import java.io.Serializable;
import java.util.List;

public class PaymentConceptBean implements Serializable {
	private static final long serialVersionUID = 1L;
	List<PaymentDetailBean> paymentDetails;
	BudgetConceptBean budgetConcept;
	ProviderBean provider;
	String name;
	int cost;
	String description;
	boolean material;
	public List<PaymentDetailBean> getPaymentDetails() {
		return paymentDetails;
	}
	public void setPaymentDetails(List<PaymentDetailBean> paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	public BudgetConceptBean getBudgetConcept() {
		return budgetConcept;
	}
	public void setBudgetConcept(BudgetConceptBean budgetConcept) {
		this.budgetConcept = budgetConcept;
	}
	public ProviderBean getProvider() {
		return provider;
	}
	public void setProvider(ProviderBean provider) {
		this.provider = provider;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isMaterial() {
		return material;
	}
	public void setMaterial(boolean material) {
		this.material = material;
	}
	
	
	

}
