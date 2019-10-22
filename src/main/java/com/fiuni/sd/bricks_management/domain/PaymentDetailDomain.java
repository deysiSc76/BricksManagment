package com.fiuni.sd.bricks_management.domain;

import java.util.ArrayList; 
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fiuni.sd.bricks_management.domain.base.BaseDomain;
import com.fiuni.sd.bricks_management.domain.PaymentConceptDomain;

@Entity
@Table(name = "payment_details")
public class PaymentDetailDomain implements BaseDomain {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "unit_price")
	private int unit_price;
	
	@Column(name = "quantity")
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_conceptP_id")
  	private PaymentDomain payment_conceptP;
  	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_id")
  	private PaymentDomain payment; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_concept_id")
	private PaymentConceptDomain payment_concept;
	
	@OneToMany(mappedBy = "payment_detail")
	private List<PaymentDomain> payments = new ArrayList<>();

	// *****************************************************************************************************************
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(int unit_price) {
		this.unit_price = unit_price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public PaymentDomain getPayment_conceptP() {
		return payment_conceptP;
	}

	public void setPayment_conceptP(PaymentDomain payment_conceptP) {
		this.payment_conceptP = payment_conceptP;
	}

	public PaymentDomain getPayment() {
		return payment;
	}

	public void setPayment(PaymentDomain payment) {
		this.payment = payment;
	}

	public PaymentConceptDomain getPayment_concept() {
		return payment_concept;
	}

	public void setPayment_concept(PaymentConceptDomain payment_concept) {
		this.payment_concept = payment_concept;
	}

	public List<PaymentDomain> getPayments() {
		return payments;
	}

	public void setPayments(List<PaymentDomain> payments) {
		this.payments = payments;
	}

	// *****************************************************************************************************************

	@Override
	public String toString() {
		return "PaymentDetailDomain [id=" + id + ", unit_price=" + unit_price + ", quantity=" + quantity
				+ ", payment_conceptP=" + payment_conceptP + ", payment=" + payment + ", payment_concept="
				+ payment_concept + ", payments=" + payments + "]";
	}
	
	// *****************************************************************************************************************
	
	
}
