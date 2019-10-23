package com.fiuni.sd.bricks_management.service.base;

import org.springframework.data.domain.Pageable;

import com.fiuni.sd.bricks_management.dto.base.BaseDTO;
import com.fiuni.sd.bricks_management.dto.base.BaseResult;

public interface IBaseService<DTO extends BaseDTO, R extends BaseResult<DTO>> {
	public DTO save(DTO dto);

	public DTO getById(Integer id);
	
	public R getAll(Pageable pageable);

}
