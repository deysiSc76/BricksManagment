package com.fiuni.sd.bricks_management.entity;

import java.io.Serializable;

public class PersonalDebtBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	int amount;
	String description;
	PaymentBean payment;
	UserBean user;
	
	// ***********************************************************************
	
	// GETTERS & SETTERS
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public PaymentBean getPayment() {
		return payment;
	}
	public void setPayment(PaymentBean payment) {
		this.payment = payment;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	
	// ***********************************************************************
	
}
