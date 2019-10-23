package com.fiuni.sd.bricks_management.domain.budgetConcept;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fiuni.sd.bricks_management.domain.base.BaseDomain;
import com.fiuni.sd.bricks_management.domain.budgetDetail.BudgetDetailDomain;
import com.fiuni.sd.bricks_management.domain.paymentConcept.PaymentConceptDomain;

@Entity
@Table(name = "budget_concepts")
public class BudgetConceptDomain implements BaseDomain {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "budget_concept")
	private List<BudgetDetailDomain> budget_details = new ArrayList<>();

	@OneToMany(mappedBy = "budget_concept")
	private List<PaymentConceptDomain> payment_concepts = new ArrayList<>();

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

	public List<BudgetDetailDomain> getBudgetDetails() {
		return budget_details;
	}

	public void setBudgetDetails(List<BudgetDetailDomain> budget_details) {
		this.budget_details = budget_details;
	}

	public List<PaymentConceptDomain> getPaymentConcepts() {
		return payment_concepts;
	}

	public void setPaymentConcepts(List<PaymentConceptDomain> payment_concepts) {
		this.payment_concepts = payment_concepts;
	}

	// *****************************************************************************************************************
	
	@Override
	public String toString() {
		return "BudgetConceptDomain [id=" + id + ", description=" + description + ", budgetDetails=" + budget_details
				+ ", paymentConcepts=" + payment_concepts + "]";
	}
	
	// *****************************************************************************************************************
	
}
