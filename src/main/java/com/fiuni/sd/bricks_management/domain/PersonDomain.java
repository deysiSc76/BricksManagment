package com.fiuni.sd.bricks_management.domain;

import java.util.HashSet;
import java.util.Set;

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

@Entity
@Table(name = "people")
public class PersonDomain implements BaseDomain{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "number")
	private int number;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password") 
	private String password;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pesonal_debt_id")
	private PersonalDebtDomain personal_debt;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "people_roles", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<RoleDomain> roles = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "people_works", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "work_id"))
	private Set<WorkDomain> people_works = new HashSet<>();

	@OneToMany(mappedBy = "client")
	private Set<WorkDomain> client_works = new HashSet<>();
	
	@OneToMany(mappedBy = "client")
	private Set<ChargeDomain> client_charges = new HashSet<>();
	
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
	
	public Set<RoleDomain> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleDomain> roles) {
		this.roles = roles;
	}

	public Set<ChargeDomain> getClient_charges() {
		return client_charges;
	}

	public void setClient_charges(Set<ChargeDomain> client_charges) {
		this.client_charges = client_charges;
	}

	public Set<WorkDomain> getPeople_works() {
		return people_works;
	}

	public void setPeople_works(Set<WorkDomain> people_works) {
		this.people_works = people_works;
	}

	// *****************************************************************************************************************

	@Override
	public String toString() {
		return "PersonDomain [id=" + id + ", name=" + name + ", number=" + number + ", address=" + address
				+ ", comment=" + comment + ", email=" + email + ", password=" + password + ", personal_debt="
				+ personal_debt + ", roles=" + roles + ", people_works=" + people_works + ", client_works="
				+ client_works + ", client_charges=" + client_charges + "]";
	}

	// *****************************************************************************************************************

}
