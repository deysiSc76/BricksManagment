package com.fiuni.sd.brick_managment.beans;

import java.io.Serializable;

public class PaymentDetailBean implements Serializable{
	private static final long serialVersionUID = 1L;
	PaymentBean paymentConceptP;
	PaymentBean header;
	PaymentConceptBean paymentConcept;
	int unitPrice;
	int quantity;
	public PaymentBean getPaymentConceptP() {
		return paymentConceptP;
	}
	public void setPaymentConcept(PaymentBean paymentConceptP) {
		this.paymentConceptP = paymentConceptP;
	}
	public PaymentBean getHeader() {
		return header;
	}
	public void setHeader(PaymentBean header) {
		this.header = header;
	}
	public PaymentConceptBean getPaymentConcept() {
		return paymentConcept;
	}
	public void setPaymentConept(PaymentConceptBean paymentConept) {
		this.paymentConcept = paymentConept;
	}
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
	

}
