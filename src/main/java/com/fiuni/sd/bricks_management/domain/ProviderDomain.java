package com.fiuni.sd.bricks_management.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fiuni.sd.bricks_management.domain.base.BaseDomain;

@Entity
@Table(name = "providers")
public class ProviderDomain implements BaseDomain {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "bussiness_name")
	private String bussiness_name;
	
	@Column(name = "number")
	private int number;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "ruc")
	private String ruc;
	
	@OneToMany(mappedBy = "provider")
	private Set<PaymentConceptDomain> payment_concepts = new HashSet<>();

	@OneToMany(mappedBy = "provider")
	private Set<PaymentDomain> payments = new HashSet<>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBussinessName() {
		return bussiness_name;
	}

	public void setBussinessName(String bussiness_name) {
		this.bussiness_name = bussiness_name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public Set<PaymentConceptDomain> getPaymentConcepts() {
		return payment_concepts;
	}

	public void setPaymentConcepts(Set<PaymentConceptDomain> payment_concepts) {
		this.payment_concepts = payment_concepts;
	}

	public Set<PaymentDomain> getPayments() {
		return payments;
	}

	public void setPayments(Set<PaymentDomain> payments) {
		this.payments = payments;
	}

	@Override
	public String toString() {
		return "ProviderDomain [id=" + id + ", businessName=" + bussiness_name + ", number=" + number + ", address="
				+ address + ", ruc=" + ruc + ", _paymentConcepts=" + payment_concepts + ", _payments=" + payments
				+ "]";
	}
	
}
