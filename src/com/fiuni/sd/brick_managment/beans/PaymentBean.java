package com.fiuni.sd.brick_managment.beans;

import java.io.Serializable;
import java.util.List;

public class PaymentBean implements Serializable{
	private static final long serialVersionUID = 1L;
	WorkBean work;
	PersonalDebtBean debt;
	ProviderBean provider;
	List<PaymentDetailBean> paymentDetais; 
	int total;
	String date;
	String documentType;
	int number;
	int stamping;
	int billType;
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
	public List<PaymentDetailBean> getPaymentDetais() {
		return paymentDetais;
	}
	public void setPaymentDetais(List<PaymentDetailBean> paymentDetais) {
		this.paymentDetais = paymentDetais;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
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
		return billType;
	}
	public void setBillType(int billType) {
		this.billType = billType;
	}
	
	


}
