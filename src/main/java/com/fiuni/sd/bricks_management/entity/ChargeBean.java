package com.fiuni.sd.bricks_management.entity;

import java.io.Serializable;

public class ChargeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String description;
	private int amount;
	private String date;
	private BudgetBean budget;
	private UserBean cliente;

	// ***********************************************************************

	// GETTERS & SETTERS

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
	public BudgetBean getBudget() {
		return budget;
	}
	public void setBudget(BudgetBean budget) {
		this.budget = budget;
	}
	public UserBean getCliente() {
		return cliente;
	}
	public void setCliente(UserBean cliente) {
		this.cliente = cliente;
	}

	// ***********************************************************************

}
