package com.fiuni.sd.bricks_management.domain;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fiuni.sd.bricks_management.domain.base.BaseDomain;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "budget_id")
	private BudgetDomain budget;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id")
	private PersonDomain client;
	
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

	public PersonDomain getClient() {
		return client;
	}

	public void setClient(PersonDomain client) {
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
