package com.fiuni.sd.bricks_management.entity;

import java.io.Serializable;
import java.util.List;

public class WorkBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String description;
	private String address;
	private String startDate;
	private String end_date;
	private String personal_manager;
	private PersonBean client;
	private BudgetBean budget;
	private List<PersonBean> managers;
	private List<PaymentBean> payments;
	
	// ***********************************************************************
	
	// GETTERS & SETTERS
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getPersonalManager() {
		return personal_manager;
	}
	public void setPersonalManager(String personal_manager) {
		this.personal_manager = personal_manager;
	}
	public PersonBean getClient() {
		return client;
	}
	public void setClient(PersonBean client) {
		this.client = client;
	}
	public BudgetBean getBudget() {
		return budget;
	}
	public void setBudget(BudgetBean budget) {
		this.budget = budget;
	}
	public List<PersonBean> getManagers() {
		return managers;
	}
	public void setManagers(List<PersonBean> managers) {
		this.managers = managers;
	}
	public List<PaymentBean> getPayments() {
		return payments;
	}
	public void setPayments(List<PaymentBean> payments) {
		this.payments = payments;
	}

	// ***********************************************************************
	
}
