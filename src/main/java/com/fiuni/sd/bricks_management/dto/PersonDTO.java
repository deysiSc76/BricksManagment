package com.fiuni.sd.bricks_management.dto;

import java.io.Serializable;

public class PersonDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int number;
	private String address;
	private String comentario;
	private String email;
	private Integer rol_id;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
	public Integer getRol() {
		return rol_id;
	}
	public void setRol(Integer rol_id) {
		this.rol_id = rol_id;
	}
	
	

}
