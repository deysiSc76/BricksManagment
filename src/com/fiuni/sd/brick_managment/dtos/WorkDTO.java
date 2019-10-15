package com.fiuni.sd.brick_managment.dtos;

import java.io.Serializable;
import java.util.List;

public class WorkDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	String name;
	String description;
	int clientId;
	String address;
	String startDate;
	String end_date;
	String personnelManager;
	int budgetId;
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
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
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
	public String getPersonnelManager() {
		return personnelManager;
	}
	public void setPersonnelManager(String personnelManager) {
		this.personnelManager = personnelManager;
	}
	
	public int getBudgetId() {
		return budgetId;
	}
	public void setBudgetId(int budgetId) {
		this.budgetId = budgetId;
	}
	
	

}
