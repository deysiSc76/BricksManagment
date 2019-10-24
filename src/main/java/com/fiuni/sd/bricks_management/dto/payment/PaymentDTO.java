package com.fiuni.sd.bricks_management.dto.payment;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.domain.paymentDetail.PaymentDetailDomain;
import com.fiuni.sd.bricks_management.dto.base.BaseDTO;
import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailDTO;

@XmlRootElement(name = "payment")
public class PaymentDTO extends BaseDTO{
	
	private static final long serialVersionUID = 1L;
	
	private int workId;
	private int debtId;
	private int providerId;
	private int total;
	private String date;
	private String documentType;
	private int number;
	private int stamping;
	private int billType;
	private List<PaymentDetailDTO> details;
	
	@XmlElement
	public List<PaymentDetailDTO> getDetails() {
		return details;
	}
	public void setDetails(List<PaymentDetailDomain> list) {
		this.details = list;
	}
	@XmlElement
	public int getWorkId() {
		return workId;
	}
	public void setWorkId(int workId) {
		this.workId = workId;
	}
	@XmlElement
	public int getDebtId() {
		return debtId;
	}
	public void setDebtId(int debtId) {
		this.debtId = debtId;
	}
	@XmlElement
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	@XmlElement
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@XmlElement
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@XmlElement
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	@XmlElement
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@XmlElement
	public int getStamping() {
		return stamping;
	}
	public void setStamping(int stamping) {
		this.stamping = stamping;
	}
	@XmlElement
	public int getBillType() {
		return billType;
	}
	public void setBillType(int billType) {
		this.billType = billType;
	}
	@Override
	public String toString() {
		return "PaymentDTO [workId=" + workId + ", debID=" + debtId + ", providerId=" + providerId
				+ ", total=" + total + ", date="+ date +", documentType="+ documentType +", number="+ number+ ", stamping"+ stamping+
				", billType"+ billType+ "]";
	}
	
	
}
