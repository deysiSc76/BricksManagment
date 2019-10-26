package com.fiuni.sd.bricks_management.dto.user;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.dto.base.BaseDTO;

@XmlRootElement(name = "person")
public class UserDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private String name;
	private int number;
	private String address;
	private String comentario;
	private String email;
	private String password;
	private Integer personal_debt_id;

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
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	@XmlElement
	public Integer getPersonalDebtId() {
		return personal_debt_id;
	}
	public void setPersonalDebtId(Integer personal_debt_id) {
		this.personal_debt_id = personal_debt_id;
	}
	@XmlElement
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
