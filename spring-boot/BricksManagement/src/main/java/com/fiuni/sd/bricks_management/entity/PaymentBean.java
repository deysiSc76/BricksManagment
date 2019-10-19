package com.fiuni.sd.bricks_management.entity;

import java.io.Serializable;
import java.util.List;

public class PaymentBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	 
	int total;
	int number;
	int stamping;
	int bill_type;
	String date;
	String document_type;
	WorkBean work;
	PersonalDebtBean debt;
	ProviderBean provider;
	List<PaymentDetailBean> payment_details;
	PaymentDetailBean payment_detail;
	
	// ***********************************************************************
	
	// GETTERS & SETTERS
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getStamping() {
		return stamping;
	}
	public void setStamping(int stamping) {
		this.stamping = stamping;
	}
	public int getBillType() {
		return bill_type;
	}
	public void setBillType(int bill_type) {
		this.bill_type = bill_type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDocumentType() {
		return document_type;
	}
	public void setDocumentType(String document_type) {
		this.document_type = document_type;
	}
	public WorkBean getWork() {
		return work;
	}
	public void setWork(WorkBean work) {
		this.work = work;
	}
	public PersonalDebtBean getDebt() {
		return debt;
	}
	public void setDebt(PersonalDebtBean debt) {
		this.debt = debt;
	}
	public ProviderBean getProvider() {
		return provider;
	}
	public void setProvider(ProviderBean provider) {
		this.provider = provider;
	}
	public List<PaymentDetailBean> getPaymentDetails() {
		return payment_details;
	}
	public void setPaymentDetais(List<PaymentDetailBean> payment_details) {
		this.payment_details = payment_details;
	}
	public PaymentDetailBean getPaymentDetail() {
		return payment_detail;
	}
	public void setPaymentDetail(PaymentDetailBean payment_detail) {
		this.payment_detail = payment_detail;
	}
	
	// ***********************************************************************
	
}
