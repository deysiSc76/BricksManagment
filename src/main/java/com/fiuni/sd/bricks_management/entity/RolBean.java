package com.fiuni.sd.bricks_management.entity;

import java.io.Serializable;
import java.util.List;

public class RolBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String type;
	List<UserBean> users;
	
	// ***********************************************************************
	
	// GETTERS & SETTERS
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<UserBean> getUsers() {
		return users;
	}
	public void setUsers(List<UserBean> users) {
		this.users = users;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	// ***********************************************************************
	
}
