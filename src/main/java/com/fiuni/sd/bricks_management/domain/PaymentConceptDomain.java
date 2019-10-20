package com.fiuni.sd.bricks_management.domain;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fiuni.sd.bricks_management.domain.base.BaseDomain;

@Entity
@Table(name = "payment_concepts")
public class PaymentConceptDomain implements BaseDomain {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "cost")
	private int cost;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "material")
	private boolean material;
	
	@ManyToOne
	private ProviderDomain provider;
	
	@ManyToOne
	private BudgetConceptDomain budget_concept;
	
	@OneToMany(mappedBy = "payment_concept")
	private List<PaymentDetailDomain> payment_details = new ArrayList<>();
	
	// *****************************************************************************************************************
	
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isMaterial() {
		return material;
	}

	public void setMaterial(boolean material) {
		this.material = material;
	}

	public ProviderDomain get_provider() {
		return provider;
	}

	public void set_provider(ProviderDomain provider) {
		this.provider = provider;
	}

	public List<PaymentDetailDomain> get_paymentDetails() {
		return payment_details;
	}

	public void set_paymentDetails(List<PaymentDetailDomain> payment_details) {
		this.payment_details = payment_details;
	}
	
	// *****************************************************************************************************************
	
	@Override
	public String toString() {
		return "PaymentConceptDomain [id=" + id + ", name=" + name + ", cost=" + cost + ", description=" + description
				+ ", material=" + material + ", _provider=" + provider + ", _paymentDetails=" + payment_details + "]";
	}
	
	// *****************************************************************************************************************
	
}
