package com.fiuni.sd.bricks_management.entity;

import java.io.Serializable;
import java.util.List;

public class UserBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String last_name;
	private int number;
	private String document;
	private String address;
	private String comment;
	private String email;
	private String password;
	private PersonalDebtBean personal_debt;
	private List<RolBean> roles;
	private List<WorkBean> works;
	private List<WorkBean> client_works;
	private List<ChargeBean> client_charges;
	
	// ***********************************************************************
	
	// GETTERS & SETTERS
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return last_name;
	}
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public PersonalDebtBean getPersonalDeby() {
		return personal_debt;
	}
	public void setPersonalDebt(PersonalDebtBean personal_debt) {
		this.personal_debt = personal_debt;
	}
	public List<RolBean> getRoles() {
		return roles;
	}
	public void setRoles(List<RolBean> roles) {
		this.roles = roles;
	}
	public List<WorkBean> getWorks() {
		return works;
	}
	public void setWorks(List<WorkBean> works) {
		this.works = works;
	}
	public List<WorkBean> getClient_works() {
		return client_works;
	}
	public void setClient_works(List<WorkBean> client_works) {
		this.client_works = client_works;
	}
	public List<ChargeBean> getClient_charges() {
		return client_charges;
	}
	public void setClient_charges(List<ChargeBean> client_charges) {
		this.client_charges = client_charges;
	}
	
	// ***********************************************************************
}
