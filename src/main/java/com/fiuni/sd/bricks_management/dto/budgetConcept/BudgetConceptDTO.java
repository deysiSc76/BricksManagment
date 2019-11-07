package com.fiuni.sd.bricks_management.dto.budgetConcept;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.dto.base.BaseDTO;
import com.fiuni.sd.bricks_management.dto.budgetDetail.BudgetDetailDTO;
import com.fiuni.sd.bricks_management.dto.paymentConcept.PaymentConceptDTO;

@XmlRootElement(name = "budgetConcept")
public class BudgetConceptDTO extends BaseDTO{
	
	private static final long serialVersionUID = 1L;
	
	private String description;
	
	private List<BudgetDetailDTO> budgetDetails;
	private List<PaymentConceptDTO> paymentConcepts;
	
	@XmlElement
	public List<BudgetDetailDTO> getBudgetDetails() {
		return budgetDetails;
	}
	public void setBudgetDetails(List<BudgetDetailDTO> budgetDetails) {
		this.budgetDetails = budgetDetails;
	}
	@XmlElement
	public List<PaymentConceptDTO> getPaymentConcepts() {
		return paymentConcepts;
	}
	public void setPaymentConcepts(List<PaymentConceptDTO> paymentConcepts) {
		this.paymentConcepts = paymentConcepts;
	}
	@XmlElement
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
