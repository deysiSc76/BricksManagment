package com.fiuni.sd.bricks_management.dto.user;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.dto.base.BaseDTO;

@XmlRootElement(name = "person")
public class UserDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private String name;
	private String last_name;
	private int number;
	private String document;
	private String address;
	private String comentario;
	private String email;
	private String password;
	private List<Integer> roles_id;

	@XmlElement
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public String getLastName() {
		return last_name;
	}
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	@XmlElement
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@XmlElement
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	@XmlElement
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@XmlElement
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	@XmlElement
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@XmlElement
	public List<Integer> getRoles() {
		return roles_id;
	}
	public void setRoles(List<Integer> roles_id) {
		this.roles_id = roles_id;
	}
}
