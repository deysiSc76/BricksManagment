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
	
	private List<BudgetDetailDTO> detailDtos;
	private List<ChargeDTO> chargeDtos;
	
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
	public List<BudgetDetailDTO> getDetailDtos(){
		return detailDtos;
	}
	public void setDetailDtos( List<BudgetDetailDTO> dtos ) {
		this.detailDtos = dtos;
	}
	@XmlElement
	public List<ChargeDTO> getChargeDtos(){
		return chargeDtos;
	}
	public void setChargeDtos( List<ChargeDTO> chargeDtos ) {
		this.chargeDtos = chargeDtos;
	}
}
