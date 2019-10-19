package com.fiuni.sd.bricks_management.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fiuni.sd.bricks_management.domain.base.BaseDomain;

@Entity
@Table(name = "personal_debts")
public class PersonalDebtDomain implements BaseDomain {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "amount")
	private int amount;
	
	@Column(name = "description")
	private String description;
	
	@OneToOne
	private PaymentDomain payment;
	
	@OneToOne
	private PersonDomain person;

	// *****************************************************************************************************************

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PaymentDomain getPayment() {
		return payment;
	}

	public void setPayment(PaymentDomain payment) {
		this.payment = payment;
	}

	public PersonDomain getPerson() {
		return person;
	}

	public void setPerson(PersonDomain person) {
		this.person = person;
	}

	// *****************************************************************************************************************

	@Override
	public String toString() {
		return "PersonalDebtDomain [id=" + id + ", amount=" + amount + ", description=" + description + ", payment="
				+ payment + ", person=" + person + "]";
	}
	
	// *****************************************************************************************************************

}
