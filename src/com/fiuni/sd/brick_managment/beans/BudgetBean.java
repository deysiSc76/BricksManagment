package com.fiuni.sd.brick_managment.beans;

import java.io.Serializable;
import java.util.List;

public class BudgetBean implements Serializable {
	private static final long serialVersionUID = 1L;
	String total_amount;
	List<BudgetDetailBean> budgets;
	public String getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}
	public List<BudgetDetailBean> getBudgets() {
		return budgets;
	}
	public void setBudgets(List<BudgetDetailBean> budgets) {
		this.budgets = budgets;
	}
	

}
