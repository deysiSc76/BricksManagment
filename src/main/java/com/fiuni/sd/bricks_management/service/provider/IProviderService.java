package com.fiuni.sd.bricks_management.service.provider;

import com.fiuni.sd.bricks_management.dto.provider.ProviderDTO;
import com.fiuni.sd.bricks_management.dto.provider.ProviderResult;
import com.fiuni.sd.bricks_management.service.base.IBaseService;

public interface IProviderService  extends IBaseService<ProviderDTO,   ProviderResult>{

	public void delete(Integer providerId);

}
