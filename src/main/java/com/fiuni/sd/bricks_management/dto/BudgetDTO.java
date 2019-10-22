package com.fiuni.sd.bricks_management.dto;

import java.io.Serializable;


public class BudgetDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer total_amount;
	
	public Integer getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(Integer total_amount) {
		this.total_amount = total_amount;
	}
	

}
