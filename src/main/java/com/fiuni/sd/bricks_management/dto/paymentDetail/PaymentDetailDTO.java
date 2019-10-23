package com.fiuni.sd.bricks_management.dto.paymentDetail;

import java.io.Serializable;

public class PaymentDetailDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	int paymentConceptPId;
	int headerId;
	int paymentConceptId;
	int unitPrice;
	int quantity;
	public int getPaymentConcepPtId() {
		return paymentConceptPId;
	}
	public void setPaymentConceptPId(int paymentConceptPId) {
		this.paymentConceptPId = paymentConceptPId;
	}
	public int getHeaderId() {
		return headerId;
	}
	public void setHeaderId(int headerId) {
		this.headerId = headerId;
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
