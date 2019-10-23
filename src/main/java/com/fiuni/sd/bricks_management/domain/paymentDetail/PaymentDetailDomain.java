package com.fiuni.sd.bricks_management.domain.paymentDetail;

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
import com.fiuni.sd.bricks_management.domain.payment.PaymentDomain;
import com.fiuni.sd.bricks_management.domain.paymentConcept.PaymentConceptDomain;

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
	
	@ManyToOne
  	private PaymentDomain payment_conceptP;
  	
	@ManyToOne
  	private PaymentDomain payment; 
	
	@ManyToOne
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

	public PaymentDomain getPaymentConceptP() {
		return payment_conceptP;
	}

	public void setPaymentConceptP(PaymentDomain payment_conceptP) {
		this.payment_conceptP = payment_conceptP;
	}

	public PaymentDomain getPayment() {
		return payment;
	}

	public void setPayment(PaymentDomain payment) {
		this.payment = payment;
	}

	public PaymentConceptDomain getPaymentConcept() {
		return payment_concept;
	}

	public void setPaymentConcept(PaymentConceptDomain payment_concept) {
		this.payment_concept = payment_concept;
	}

	public int getUnitPrice() {
		return unit_price;
	}

	public void setUnitPrice(int unit_price) {
		this.unit_price = unit_price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// *****************************************************************************************************************
	
	@Override
	public String toString() {
		return "PaymentDetailDomain [id=" + id + ", paymentConceptP=" + payment_conceptP + ", payment=" + payment
				+ ", paymentConcept=" + payment_concept + ", unitPrice=" + unit_price + ", quantity=" + quantity + "]";
	}
	
	// *****************************************************************************************************************
	
}
