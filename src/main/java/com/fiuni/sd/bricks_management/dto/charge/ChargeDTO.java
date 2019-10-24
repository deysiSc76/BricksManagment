package com.fiuni.sd.bricks_management.dto.charge;

import java.io.Serializable;

public class ChargeDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String description;
	private int amount;
	private String date;
	private int budget_id;
	private int client_id;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getBudgetId() {
		return budget_id;
	}
	public void setBudgetId(int budgetId) {
		this.budget_id = budgetId;
	}
	public int getClientId() {
		return client_id;
	}
	public void setClientId(int clienteId) {
		this.client_id = clienteId;
	}
	
	

}
