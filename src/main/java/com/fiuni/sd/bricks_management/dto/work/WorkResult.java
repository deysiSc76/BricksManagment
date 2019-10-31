package com.fiuni.sd.bricks_management.dto.work;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.dto.base.BaseResult;

@XmlRootElement(name = "workResult")
public class WorkResult extends BaseResult<WorkDTO>{

	private static final long serialVersionUID = 1L;
	
	@XmlElement
	public List<WorkDTO> getWorks() {
		return getList();
	}
	
	public void setWorks(List<WorkDTO> works) {
		super.setList(works);
	}
}
