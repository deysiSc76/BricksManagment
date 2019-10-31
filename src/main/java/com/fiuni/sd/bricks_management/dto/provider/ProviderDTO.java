package com.fiuni.sd.bricks_management.dto.provider;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.dto.base.BaseDTO;

@XmlRootElement(name = "provider")
public class ProviderDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	private String bussinessName;
	private int number;
	private String address;
	private String ruc;
	
	@XmlElement
	public String getBusinessName() {
		return bussinessName;
	}
	
	public void setBusinessName(String bussinessName) {
		this.bussinessName = bussinessName;
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
		return "ProviderDTO [bussinessName=" + bussinessName + ", number=" + number + ", address=" + address
				+ ", ruc=" + ruc + "]";
	}
	

}
