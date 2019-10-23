package com.fiuni.sd.bricks_management.domain.charge;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fiuni.sd.bricks_management.domain.base.BaseDomain;
import com.fiuni.sd.bricks_management.domain.budget.BudgetDomain;
import com.fiuni.sd.bricks_management.domain.user.UserDomain;

@Entity
@Table(name = "charges")
public class ChargeDomain implements BaseDomain {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "amount")
	private int amount;
	
	@Column(name = "date")
	private String date;
	
	@ManyToOne
	private BudgetDomain budget;
	
	@ManyToOne
	private UserDomain client;
	
	// *****************************************************************************************************************

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public BudgetDomain getBudget() {
		return budget;
	}

	public void setBudget(BudgetDomain budget) {
		this.budget = budget;
	}

	public UserDomain getClient() {
		return client;
	}

	public void setClient(UserDomain client) {
		this.client = client;
	}
	
	// *****************************************************************************************************************

	@Override
	public String toString() {
		return "ChargeDomain [id=" + id + ", description=" + description + ", amount=" + amount + ", date=" + date
				+ ", budget=" + budget + ", person=" + client + "]";
	}

	// *****************************************************************************************************************
	
}
