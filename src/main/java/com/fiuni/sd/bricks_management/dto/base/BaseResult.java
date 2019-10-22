package com.fiuni.sd.bricks_management.dto.base;

import java.io.Serializable;
import java.util.List;

public abstract class BaseResult<DTO extends BaseDTO> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<DTO> dtos;

	public List<DTO> getList() {
		return dtos;
	}

	public void setList(List<DTO> dtos) {
		this.dtos = dtos;
	}
	
	public Integer getTotal() {
		return null == dtos ? 0 : dtos.size();
	}
	
}
