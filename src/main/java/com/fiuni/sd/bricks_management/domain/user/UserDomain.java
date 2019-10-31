package com.fiuni.sd.bricks_management.domain.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fiuni.sd.bricks_management.domain.base.BaseDomain;
import com.fiuni.sd.bricks_management.domain.charge.ChargeDomain;
import com.fiuni.sd.bricks_management.domain.personalDebt.PersonalDebtDomain;
import com.fiuni.sd.bricks_management.domain.role.RoleDomain;
import com.fiuni.sd.bricks_management.domain.work.WorkDomain;

@Entity
@Table(name = "users")
public class UserDomain implements BaseDomain{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "number")
	private int number;

	@Column(name = "document")
	private String document;
	
	@Column(name = "address")
	private String address;

	@Column(name = "comment")
	private String comment;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private PersonalDebtDomain personal_debt;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<RoleDomain> roles = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_works", joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "work_id"))
	private List<WorkDomain> user_works = new ArrayList<>();

	@OneToMany(mappedBy = "client")
	private List<WorkDomain> client_works = new ArrayList<>();

	@OneToMany(mappedBy = "client")
	private List<ChargeDomain> client_charges = new ArrayList<>();

	// *****************************************************************************************************************

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public PersonalDebtDomain getPersonalDebt() {
		return personal_debt;
	}

	public void setPersonalDebt(PersonalDebtDomain personal_debt) {
		this.personal_debt = personal_debt;
	}

	public List<RoleDomain> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDomain> roles) {
		this.roles = roles;
	}

	public List<ChargeDomain> getClient_charges() {
		return client_charges;
	}

	public void setClient_charges(List<ChargeDomain> client_charges) {
		this.client_charges = client_charges;
	}

	public List<WorkDomain> getUserWorks() {
		return user_works;
	}

	public void setUserWorks(List<WorkDomain> user_works) {
		this.user_works = user_works;
	}

	// *****************************************************************************************************************

	@Override
	public String toString() {
		return "UserDomain [id=" + id + ", name=" + name + ", lastName=" + lastName + ", number=" + number
				+ ", document=" + document + ", address=" + address + ", comment=" + comment + ", email=" + email
				+ ", password=" + password + ", personal_debt=" + personal_debt + ", roles=" + roles + ", user_works="
				+ user_works + ", client_works=" + client_works + ", client_charges=" + client_charges + "]";
	}

	// *****************************************************************************************************************

}
