package com.fiuni.sd.bricks_management.entity;

import java.io.Serializable;
import java.util.List;

public class ProviderBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String business_name;
	private int number;
	private String address;
	private String ruc;
	private List<PaymentBean> payments;
	private List<PaymentConceptBean> payment_concepts;
	
	// ***********************************************************************
	
	// GETTERS & SETTERS
	
	public String getBusinessName() {
		return business_name;
	}
	public void setBusinessName(String business_name) {
		this.business_name = business_name;
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
	public List<PaymentBean> getPayments() {
		return payments;
	}
	public void setPayments(List<PaymentBean> payments) {
		this.payments = payments;
	}
	public List<PaymentConceptBean> getPaymentConcepts() {
		return payment_concepts;
	}
	public void setPaymentConcepts(List<PaymentConceptBean> payment_concepts) {
		this.payment_concepts = payment_concepts;
	}
	
	// ***********************************************************************
	
}
