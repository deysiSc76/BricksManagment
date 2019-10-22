package com.fiuni.sd.bricks_management.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.dto.base.BaseResult;

@XmlRootElement(name = "personResult")
public class PersonResult extends BaseResult<PersonDTO> {

	private static final long serialVersionUID = 1L;
	
	@XmlElement
	public List<PersonDTO> getPeople() {
		return getList();
	}
	
	public void setPeople(List<PersonDTO> dtos) {
		super.setList(dtos);
	}
	
}
