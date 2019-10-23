package com.fiuni.sd.bricks_management.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.dto.base.BaseDTO;

@XmlRootElement(name = "person")
public class PersonDTO extends BaseDTO {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int number;
	private String address;
	private String comentario;
	private String email;
	private List<Integer> roles_id;
	
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
	
	public List<Integer> getRoles() {
		return roles_id;
	}
	public void setRoles(List<Integer> roles_id) {
		this.roles_id = roles_id;
	}
	
}
