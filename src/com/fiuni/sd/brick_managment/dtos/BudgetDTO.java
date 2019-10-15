package com.fiuni.sd.brick_managment.dtos;

import java.io.Serializable;


public class BudgetDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	String total_amount;
	public String getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}
	

}
