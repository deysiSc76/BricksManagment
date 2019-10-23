package com.fiuni.sd.bricks_management.entity;

import java.io.Serializable;
import java.util.List;

public class PaymentConceptBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int cost;
	private String description;
	private boolean material;
	private BudgetConceptBean budget_concept;
	private ProviderBean provider;
	private List<PaymentDetailBean> payment_details;
	
	// *****************************************************************************************************************
	
	public List<PaymentDetailBean> getPaymentDetails() {
		return payment_details;
	}
	public void setPaymentDetails(List<PaymentDetailBean> payment_details) {
		this.payment_details = payment_details;
	}
	public BudgetConceptBean getBudgetConcept() {
		return budget_concept;
	}
	public void setBudgetConcept(BudgetConceptBean budget_concept) {
		this.budget_concept = budget_concept;
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

	// *****************************************************************************************************************
		
}
