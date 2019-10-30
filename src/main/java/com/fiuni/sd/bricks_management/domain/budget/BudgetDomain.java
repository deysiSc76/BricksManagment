package com.fiuni.sd.bricks_management.domain.budget;

import java.util.ArrayList; 
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fiuni.sd.bricks_management.domain.base.BaseDomain;
import com.fiuni.sd.bricks_management.domain.budgetDetail.BudgetDetailDomain;
import com.fiuni.sd.bricks_management.domain.charge.ChargeDomain;
import com.fiuni.sd.bricks_management.domain.work.WorkDomain;

@Entity
@Table(name = "budgets")
public class BudgetDomain implements BaseDomain {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "total_amount")
	private Integer total_amount;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "budget")
	private WorkDomain work;
	
	@OneToMany(mappedBy = "budget")
	private List<BudgetDetailDomain> budget_details = new ArrayList<>();
	
	@OneToMany(mappedBy = "budget")
	private List<ChargeDomain> charges = new ArrayList<>();

	// ***********************************************************************************************************
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTotalAmount() {
		return total_amount;
	}

	public void setTotalAmount(Integer total_amount) {
		this.total_amount = total_amount;
	}

	public WorkDomain getWork() {
		return work;
	}

	public void setWork(WorkDomain work) {
		this.work = work;
	}

	public List<BudgetDetailDomain> getBudgetDetails() {
		return budget_details;
	}

	public void setBudgetDetails(List<BudgetDetailDomain> budget_details) {
		this.budget_details = budget_details;
	}

	public List<ChargeDomain> getCharges() {
		return charges;
	}

	public void setCharges(List<ChargeDomain> charges) {
		this.charges = charges;
	}

	// ***********************************************************************************************************
	
	@Override
	public String toString() {
		return "BudgetDomain [id=" + id + ", total_amount=" + total_amount + ", work=" + work + ", budgetDetails="
				+ budget_details + ", charges=" + charges + "]";
	}
	
	// ***********************************************************************************************************
	
}
