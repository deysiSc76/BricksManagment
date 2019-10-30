package com.fiuni.sd.bricks_management.dto.personalDebt;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.dto.base.BaseDTO;

@XmlRootElement(name = "personal_debt")
public class PersonalDebtDTO extends BaseDTO {
	
	private static final long serialVersionUID = 1L;
	private int amount;
	private String description;
	private Integer user_id;
	
	@XmlElement
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@XmlElement
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@XmlElement
	public Integer getUserId() {
		return user_id;
	}
	public void setUserId(Integer user_id) {
		this.user_id = user_id;
	}
}
