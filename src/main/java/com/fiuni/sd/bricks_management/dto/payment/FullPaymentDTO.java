package com.fiuni.sd.bricks_management.dto.payment;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailDTO;

@XmlRootElement(name = "payment")
public class FullPaymentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private PaymentDTO payment;
	private List<PaymentDetailDTO> details;
	
	public PaymentDTO getPayment() {
		return payment;
	}
	public void setPayment(PaymentDTO payment) {
		this.payment = payment;
	}
	public List<PaymentDetailDTO> getDetails() {
		return details;
	}
	public void setDetails(List<PaymentDetailDTO> details) {
		this.details = details;
	}
	public int getTotalDetails() {
		return details != null ? details.size() : 0;
	}
	
	
}
