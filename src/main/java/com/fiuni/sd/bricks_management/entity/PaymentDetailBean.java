package com.fiuni.sd.bricks_management.entity;

import java.io.Serializable;
import java.util.List;

public class PaymentDetailBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	int unitPrice;
	int quantity;
	PaymentBean payment_conceptP;
	PaymentBean header;
	PaymentConceptBean payment_concept;
	List<PaymentBean> payments;
	
	// ***********************************************************************
	
	// GETTERS & SETTERS
	
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public PaymentBean getPaymentConceptP() {
		return payment_conceptP;
	}
	public void setPaymentConceptP(PaymentBean payment_conceptP) {
		this.payment_conceptP = payment_conceptP;
	}
	public PaymentBean getHeader() {
		return header;
	}
	public void setHeader(PaymentBean header) {
		this.header = header;
	}
	public PaymentConceptBean getPaymentConcept() {
		return payment_concept;
	}
	public void setPaymentConcept(PaymentConceptBean payment_concept) {
		this.payment_concept = payment_concept;
	}
	public List<PaymentBean> getPayments() {
		return payments;
	}
	public void setPayments(List<PaymentBean> payments) {
		this.payments = payments;
	}
	
	// ***********************************************************************
	
}
