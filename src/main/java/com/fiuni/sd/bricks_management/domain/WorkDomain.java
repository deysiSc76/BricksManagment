package com.fiuni.sd.bricks_management.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fiuni.sd.bricks_management.domain.base.BaseDomain;
import com.fiuni.sd.bricks_management.domain.WorkDomain;

@Entity
@Table(name = "works")
public class WorkDomain implements BaseDomain {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "start_date")
	private String start_date;
	
	@Column(name = "end_date")
	private String end_date;
	
	@Column(name = "personal_manager")
	private String personal_manager;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "budget_id")
	private BudgetDomain budget;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id")
	private PersonDomain client;
	
	@OneToMany(mappedBy = "work")
	private Set<PaymentDomain> payments = new HashSet<>();
	// ***********************************************************************************************************
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStartDate() {
		return start_date;
	}

	public void setStartDate(String start_date) {
		this.start_date = start_date;
	}

	public String getEndDate() {
		return end_date;
	}

	public void setEndDate(String end_date) {
		this.end_date = end_date;
	}

	public String getPersonManager() {
		return personal_manager;
	}

	public void setPersonManager(String personal_manager) {
		this.personal_manager = personal_manager;
	}

	public PersonDomain getClient() {
		return client;
	}

	public void setClient(PersonDomain client) {
		this.client = client;
	}

	public BudgetDomain getBudget() {
		return budget;
	}
	
	public void setBudget(BudgetDomain budget) {
		this.budget = budget;
	}
	
	public Set<PaymentDomain> getPayments() {
		return payments;
	}

	public void setPayments(Set<PaymentDomain> payments) {
		this.payments = payments;
	}

	// ***********************************************************************************************************
	
	@Override
	public String toString() {
		return "WorkDomain [id=" + id + ", name=" + name + ", description=" + description + ", address=" + address
				+ ", start_date=" + start_date + ", end_date=" + end_date + ", personal_manager=" + personal_manager
				+ ", budget=" + budget + ", client=" + client + ", payments=" + payments + "]";
	}
	
	// ***********************************************************************************************************
	
}
