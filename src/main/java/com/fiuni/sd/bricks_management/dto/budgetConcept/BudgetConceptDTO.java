package com.fiuni.sd.bricks_management.dto.budgetConcept;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.dto.base.BaseDTO;

@XmlRootElement(name = "budgetConcept")
public class BudgetConceptDTO extends BaseDTO{
	
	private static final long serialVersionUID = 1L;
	
	private String description;
	@XmlElement
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
