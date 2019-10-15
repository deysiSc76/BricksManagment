package com.fiuni.sd.brick_managment.beans;

import java.io.Serializable;

public class ChargeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	String description;
	int amount;
	String date;
	BudgetBean budget;
	PersonBean cliente;
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
	public PersonBean getCliente() {
		return cliente;
	}
	public void setCliente(PersonBean cliente) {
		this.cliente = cliente;
	}
	
	

}
