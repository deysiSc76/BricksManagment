package com.fiuni.sd.bricks_management.dto.paymentDetail;

import java.io.Serializable;

public class PaymentDetailDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int unitPrice;
	private int quantity;
	private int payment_id;
	private int paymentConceptId;
	private int paymentConceptPId;
	
	public int getPaymentConcepPtId() {
		return paymentConceptPId;
	}
	public void setPaymentConceptPId(int paymentConceptPId) {
		this.paymentConceptPId = paymentConceptPId;
	}
	public int getPaymentId() {
		return payment_id;
	}
	public void setPaymentId(int headerId) {
		this.payment_id = headerId;
	}
	public int getPaymentConceptId() {
		return paymentConceptId;
	}
	public void setPaymentConcept(int paymentConceptId) {
		this.paymentConceptId = paymentConceptId;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
