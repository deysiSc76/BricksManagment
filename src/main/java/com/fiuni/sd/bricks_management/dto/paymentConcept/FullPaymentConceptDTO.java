package com.fiuni.sd.bricks_management.dto.paymentConcept;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.dto.budgetConcept.BudgetConceptDTO;
import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailDTO;

@XmlRootElement(name = "paymentConcept")
public class FullPaymentConceptDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private PaymentConceptDTO paymentConcept;
	private List<PaymentDetailDTO> details;
	private List<BudgetConceptDTO> budgetConcept;
	
	public PaymentConceptDTO getPayment() {
		return paymentConcept;
	}
	public void setPayment(PaymentConceptDTO paymentConcept) {
		this.paymentConcept = paymentConcept;
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
	public List<BudgetConceptDTO> getBudgetConcept(){
		return budgetConcept;
	}
	public void setBudgetConcept(List<BudgetConceptDTO> budgetConcept){
		this.budgetConcept=budgetConcept;
	}
	
	
}
