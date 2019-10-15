package com.fiuni.sd.brick_managment.dtos;

import java.io.Serializable;


public class BudgetConceptDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
