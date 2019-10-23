package com.fiuni.sd.bricks_management.service.base;

import com.fiuni.sd.bricks_management.domain.base.BaseDomain;
import com.fiuni.sd.bricks_management.dto.base.BaseDTO;
import com.fiuni.sd.bricks_management.dto.base.BaseResult;

public abstract class BaseServiceImpl<DTO extends BaseDTO, DOMAIN extends BaseDomain,  RESULT extends BaseResult<DTO>> implements IBaseService<DTO,   RESULT> {

	protected abstract DTO convertDomainToDto(DOMAIN domain);

	protected abstract DOMAIN convertDtoToDomain(DTO dto);

}
