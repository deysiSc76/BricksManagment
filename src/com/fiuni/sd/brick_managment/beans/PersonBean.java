package com.fiuni.sd.brick_managment.beans;

import java.io.Serializable;
import java.util.List;

public class PersonBean implements Serializable{
	private static final long serialVersionUID = 1L;
	String name;
	int number;
	String address;
	String comentario;
	List<RolBean> roles;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public List<RolBean> getRoles() {
		return roles;
	}
	public void setRoles(List<RolBean> roles) {
		this.roles = roles;
	}
	
	
	

}
