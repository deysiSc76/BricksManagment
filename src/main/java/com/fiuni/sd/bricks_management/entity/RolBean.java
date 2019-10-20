package com.fiuni.sd.bricks_management.entity;

import java.io.Serializable;
import java.util.List;

public class RolBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String type;
	List<PersonBean> persons;
	
	// ***********************************************************************
	
	// GETTERS & SETTERS
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<PersonBean> getPersons() {
		return persons;
	}
	public void setPersons(List<PersonBean> persons) {
		this.persons = persons;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	// ***********************************************************************
	
}
