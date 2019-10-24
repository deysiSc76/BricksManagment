package com.fiuni.sd.bricks_management.dto.personalDebt;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.dto.base.BaseResult;

@XmlRootElement(name = "personalDebtResult")
public class PersonalDebtResult extends BaseResult<PersonalDebtDTO> {

	private static final long serialVersionUID = 1L;
	
	@XmlElement
	public List<PersonalDebtDTO> getPersonalDebts() {
		return getList();
	}
	
	public void setPersonalDebts(List<PersonalDebtDTO> personalDebts) {
		super.setList(personalDebts);
	}
	
}
