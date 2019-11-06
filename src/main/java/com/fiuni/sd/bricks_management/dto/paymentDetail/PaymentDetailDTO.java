package com.fiuni.sd.bricks_management.dto.paymentDetail;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.dto.base.BaseDTO;

@XmlRootElement(name = "paymentDetail")
public class PaymentDetailDTO extends BaseDTO {	
	private static final long serialVersionUID = 1L;
	
	private int unitPrice;
	private int quantity;
	
	private Integer payment_id;
	private Integer paymentConceptId;
	private Integer paymentRealatedId;
	
	@XmlElement
	public Integer getPaymentRelatedId() {
		return paymentRealatedId;
	}
	public void setPaymentRelatedId(int paymentRelatedId) {
		this.paymentRealatedId = paymentRelatedId;
	}
	@XmlElement
	public Integer getPaymentId() {
		return payment_id;
	}
	public void setPaymentId(int headerId) {
		this.payment_id = headerId;
	}
	@XmlElement
	public Integer getPaymentConceptId() {
		return paymentConceptId;
	}
	public void setPaymentConceptId(int paymentConceptId) {
		this.paymentConceptId = paymentConceptId;
	}
	@XmlElement
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	@XmlElement
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof PaymentDetailDTO) {
			return ((PaymentDetailDTO) obj).getId().equals(getId());
		}
		return false;
	}
	@Override
	public int hashCode() {final int prime = 31;
	 int result = 1;
	 result = prime * result + getId();
	 return result;
	}

}