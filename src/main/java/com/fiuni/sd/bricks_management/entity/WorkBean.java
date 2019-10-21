package com.fiuni.sd.bricks_management.entity;

import java.io.Serializable;
import java.util.List;

public class WorkBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String name;
	String description;
	String address;
	String startDate;
	String end_date;
	String personal_manager;
	UserBean client;
	List<UserBean> managers;
	List<PaymentBean> payments;
	
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
	public UserBean getClient() {
		return client;
	}
	public void setClient(UserBean client) {
		this.client = client;
	}
	public List<UserBean> getManagers() {
		return managers;
	}
	public void setManagers(List<UserBean> managers) {
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
