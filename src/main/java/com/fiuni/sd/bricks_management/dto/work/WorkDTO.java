package com.fiuni.sd.bricks_management.dto.work;

import java.io.Serializable;

public class WorkDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private int clientId;
	private String address;
	private String startDate;
	private String end_date;
	private String personnelManager;
	private int budgetId;
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
