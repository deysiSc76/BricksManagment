package com.fiuni.sd.bricks_management.dto.budget;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.dto.base.BaseDTO;
import com.fiuni.sd.bricks_management.dto.budgetDetail.BudgetDetailDTO;
import com.fiuni.sd.bricks_management.dto.charge.ChargeDTO;

@XmlRootElement(name = "budget")
public class BudgetDTO extends BaseDTO{
	
	private static final long serialVersionUID = 1L;
	
	private Integer totalAmount;
	private Integer workId;
	
	private List<BudgetDetailDTO> details;
	private List<ChargeDTO> charges;
	
	public void addDetail(BudgetDetailDTO detail) {
		details.add(detail);
	}
	
	@XmlElement
	public Integer getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Integer total_amount) {
		this.totalAmount = total_amount;
	}
	@XmlElement
	public Integer getWorkId() {
		return workId;
	}
	public void setWorkId(Integer id) {
		this.workId = id;
	}
	@XmlElement
	public List<BudgetDetailDTO> getDetails(){
		return details;
	}
	public void setDetails( List<BudgetDetailDTO> details ) {
		this.details = details;
	}
	@XmlElement
	public List<ChargeDTO> getCharges() {
		return charges;
	}
	public void setCharges(List<ChargeDTO> charges) {
		this.charges = charges;
	}
}