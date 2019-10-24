package com.fiuni.sd.bricks_management.dto.charge;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.dto.base.BaseResult;

@XmlRootElement(name = "chargeResult")
public class ChargeResult extends BaseResult<ChargeDTO> {
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	public List<ChargeDTO> getCharges() {
		return getList();
	}
	
	public void setCharges(List<ChargeDTO> dtos) {
		super.setList(dtos);
	}
}
