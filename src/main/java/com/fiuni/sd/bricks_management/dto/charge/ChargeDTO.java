package com.fiuni.sd.bricks_management.dto.charge;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.dto.base.BaseDTO;

@XmlRootElement(name = "charge")
public class ChargeDTO extends BaseDTO{
	
	private static final long serialVersionUID = 1L;
	
	private String description;
	private int amount;
	private String date;
	private int budget_id;
	private int client_id;
	
	@XmlElement
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@XmlElement
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@XmlElement
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@XmlElement
	public int getBudgetId() {
		return budget_id;
	}
	public void setBudgetId(int budgetId) {
		this.budget_id = budgetId;
	}
	@XmlElement
	public int getClientId() {
		return client_id;
	}
	public void setClientId(int clienteId) {
		this.client_id = clienteId;
	}
	
}
