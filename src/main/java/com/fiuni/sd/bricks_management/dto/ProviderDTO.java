package com.fiuni.sd.bricks_management.dto;

import java.io.Serializable;

public class ProviderDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String businessName;
	private int number;
	private String address;
	private String ruc;
	
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
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
	

}
