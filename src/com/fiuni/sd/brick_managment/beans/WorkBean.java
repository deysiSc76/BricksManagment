package com.fiuni.sd.brick_managment.beans;

import java.io.Serializable;
import java.util.List;

public class WorkBean implements Serializable{
	private static final long serialVersionUID = 1L;
	String name;
	String description;
	PersonBean client;
	String address;
	String startDate;
	String end_date;
	String personnelManager;
	List<PersonBean> manager;
	BudgetBean budget;
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
	public PersonBean getClient() {
		return client;
	}
	public void setClient(PersonBean client) {
		this.client = client;
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
	public List<PersonBean> getManager() {
		return manager;
	}
	public void setManager(List<PersonBean> manager) {
		this.manager = manager;
	}
	public BudgetBean getBudget() {
		return budget;
	}
	public void setBudget(BudgetBean budget) {
		this.budget = budget;
	}
	
	

}
