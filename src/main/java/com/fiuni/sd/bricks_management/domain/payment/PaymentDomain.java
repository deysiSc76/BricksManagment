package com.fiuni.sd.bricks_management.domain.payment;

import java.util.ArrayList;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fiuni.sd.bricks_management.domain.base.BaseDomain;
import com.fiuni.sd.bricks_management.domain.paymentDetail.PaymentDetailDomain;
import com.fiuni.sd.bricks_management.domain.provider.ProviderDomain;
import com.fiuni.sd.bricks_management.domain.work.WorkDomain;

@Entity
@Table(name = "payments")
public class PaymentDomain implements BaseDomain {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "total")
	private int total;
	
	@Column(name = "number")
	private int number;
	
	@Column(name = "stamping")
	private int stamping;
	
	@Column(name = "bill_type")
	private int bill_type;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "document_type")
	private String document_type;
	
	@ManyToOne
	private WorkDomain work;
	
	@ManyToOne
	private ProviderDomain provider;
	
	@OneToMany(mappedBy = "payment")
	private List<PaymentDetailDomain> payment_details = new ArrayList<>();
	
	@ManyToOne
	private PaymentDetailDomain payment_detail;
	
	// *****************************************************************************************************************
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getStamping() {
		return stamping;
	}

	public void setStamping(int stamping) {
		this.stamping = stamping;
	}

	public int getBill_type() {
		return bill_type;
	}

	public void setBill_type(int bill_type) {
		this.bill_type = bill_type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDocument_type() {
		return document_type;
	}

	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}

	public WorkDomain getWork() {
		return work;
	}

	public void setWork(WorkDomain work) {
		this.work = work;
	}

	public ProviderDomain getProvider() {
		return provider;
	}

	public void setProvider(ProviderDomain provider) {
		this.provider = provider;
	}

	public List<PaymentDetailDomain> getPayment_details() {
		return payment_details;
	}

	public void setPayment_details(List<PaymentDetailDomain> payment_details) {
		this.payment_details = payment_details;
	}

	public PaymentDetailDomain getPayment_detail() {
		return payment_detail;
	}

	public void setPayment_detail(PaymentDetailDomain payment_detail) {
		this.payment_detail = payment_detail;
	}

	// *****************************************************************************************************************

	@Override
	public String toString() {
		return "PaymentDomain [id=" + id + ", total=" + total + ", number=" + number + ", stamping=" + stamping
				+ ", bill_type=" + bill_type + ", date=" + date + ", document_type=" + document_type + ", work=" + work
				+ ", provider=" + provider + ", payment_details=" + payment_details
				+ ", payment_detail=" + payment_detail + "]";
	}

	// *****************************************************************************************************************
	
}
