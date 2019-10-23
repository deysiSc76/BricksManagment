package com.fiuni.sd.bricks_management.dto.provider;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.dto.base.BaseDTO;

@XmlRootElement(name = "provider")
public class ProviderDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	String businessName;
	int number;
	String address;
	String ruc;
	
	@XmlElement
	public String getBusinessName() {
		return businessName;
	}
	
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	@XmlElement
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@XmlElement
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@XmlElement
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	@Override
	public String toString() {
		return "ProviderDTO [businessName=" + businessName + ", number=" + number + ", address=" + address
				+ ", ruc=" + ruc + "]";
	}
	

}
