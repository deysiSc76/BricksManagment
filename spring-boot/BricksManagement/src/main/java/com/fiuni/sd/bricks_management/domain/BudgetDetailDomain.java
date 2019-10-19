package com.fiuni.sd.bricks_management.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fiuni.sd.bricks_management.domain.base.BaseDomain;

@Entity
@Table(name = "budget_details")
public class BudgetDetailDomain implements BaseDomain{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "amount")
	private int amount;
	
	@Column(name = "quantity")
	private int quantity;
	
	@ManyToOne
	private BudgetDomain budget;
	
	@ManyToOne
	private BudgetConceptDomain budget_concept;

	// *****************************************************************************************************************
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BudgetDomain getBudget() {
		return budget;
	}

	public void setBudget(BudgetDomain budget) {
		this.budget = budget;
	}

	public BudgetConceptDomain getBudgetConcept() {
		return budget_concept;
	}

	public void setBudgetConcept(BudgetConceptDomain budget_concept) {
		this.budget_concept = budget_concept;
	}
	
	// *****************************************************************************************************************

	@Override
	public String toString() {
		return "BudgetDetailDomain [id=" + id + ", amount=" + amount + ", quantity=" + quantity + ", budget=" + budget
				+ ", budgetConcept=" + budget_concept + "]";
	}
	
	// *****************************************************************************************************************
	
}
