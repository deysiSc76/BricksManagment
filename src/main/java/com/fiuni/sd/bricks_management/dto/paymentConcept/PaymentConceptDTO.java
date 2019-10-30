package com.fiuni.sd.bricks_management.dto.paymentConcept;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.dto.base.BaseDTO;

@XmlRootElement(name = "paymentDetail")
public class PaymentConceptDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private String name;
	private int cost;
	private String description;
	private boolean material;
	private int budgetConceptId;
	private int providerId;
	
	@XmlElement
	public int getBudgetConceptId() {
		return budgetConceptId;
	}
	public void setBudgetConceptId(int budgetConceptId) {
		this.budgetConceptId = budgetConceptId;
	}
	@XmlElement
	public int getProviderId() {
		return providerId;
	}
	public void setProvider(int providerId) {
		this.providerId = providerId;
	}
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	@XmlElement
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isMaterial() {
		return material;
	}
	public void setMaterial(boolean material) {
		this.material = material;
	}
	
	
	

}
