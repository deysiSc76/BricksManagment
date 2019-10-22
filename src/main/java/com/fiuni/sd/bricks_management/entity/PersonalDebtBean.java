package com.fiuni.sd.bricks_management.entity;

import java.io.Serializable;

public class PersonalDebtBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int amount;
	private String description;
	private PaymentBean payment;
	private PersonBean person;
	
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
	public PersonBean getPerson() {
		return person;
	}
	public void setPerson(PersonBean person) {
		this.person = person;
	}
	
	// ***********************************************************************
	
}
