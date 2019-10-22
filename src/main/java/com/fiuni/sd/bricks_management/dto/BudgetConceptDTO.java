package com.fiuni.sd.bricks_management.dto;

import java.io.Serializable;


public class BudgetConceptDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
