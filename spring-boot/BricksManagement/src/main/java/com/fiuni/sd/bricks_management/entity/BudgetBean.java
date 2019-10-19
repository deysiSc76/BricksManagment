package com.fiuni.sd.bricks_management.entity;

import java.io.Serializable;
import java.util.List;

public class BudgetBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String total_amount;
	WorkBean work;
	List<BudgetDetailBean> budget_details;
	List<ChargeBean> charges;
	
	// ***********************************************************************
	
	// GETTERS & SETTERS
	
	public String getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}
	public WorkBean getWork() {
		return work;
	}
	public void setWork(WorkBean work) {
		this.work = work;
	}
	public List<BudgetDetailBean> getBudgets() {
		return budget_details;
	}
	public void setBudgets(List<BudgetDetailBean> budget_details) {
		this.budget_details = budget_details;
	}
	public List<ChargeBean> getCharges() {
		return charges;
	}
	public void setCharges(List<ChargeBean> charges) {
		this.charges = charges;
	}
	
	// ***********************************************************************
	
}
