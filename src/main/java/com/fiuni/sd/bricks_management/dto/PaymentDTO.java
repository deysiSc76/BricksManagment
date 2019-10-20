package com.fiuni.sd.bricks_management.dto;

import java.io.Serializable;

public class PaymentDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	int workId;
	int debtId;
	int providerId;
	int total;
	String date;
	String documentType;
	int number;
	int stamping;
	int billType;
	public int getWorkId() {
		return workId;
	}
	public void setWorkId(int workId) {
		this.workId = workId;
	}
	public int getDebtId() {
		return debtId;
	}
	public void setDebtId(int debtId) {
		this.debtId = debtId;
	}
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
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
