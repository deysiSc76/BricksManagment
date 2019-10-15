package com.fiuni.sd.brick_managment.dtos;

import java.io.Serializable;

public class PersonalDebtDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	int amount;
	int description;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getDescription() {
		return description;
	}
	public void setDescription(int description) {
		this.description = description;
	}
	
	

}
