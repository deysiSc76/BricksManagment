package com.fiuni.sd.bricks_management.service.provider;

import org.springframework.data.domain.Pageable;

import com.fiuni.sd.bricks_management.dto.provider.ProviderDTO;
import com.fiuni.sd.bricks_management.dto.provider.ProviderResult;
import com.fiuni.sd.bricks_management.service.base.IBaseService;

public interface IProviderService  extends IBaseService<ProviderDTO,   ProviderResult>{

	public void delete(Integer providerId);
	
	public ProviderResult getByBussinessName(String bussinessName, Pageable pageable);
	
	public ProviderResult getByRuc(String ruc, Pageable pageable);
	
	public ProviderResult getByBussinessNameAndRuc(String bussinessName, String ruc, Pageable pageable);
}
