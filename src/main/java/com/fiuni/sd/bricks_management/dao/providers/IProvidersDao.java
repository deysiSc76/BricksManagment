package com.fiuni.sd.bricks_management.dao.providers;

import java.util.List;

import com.fiuni.sd.bricks_management.dao.base.IBaseDao;
import com.fiuni.sd.bricks_management.domain.ProviderDomain;

public interface IProvidersDao extends IBaseDao<ProviderDomain>{

	public List<ProviderDomain> find(String text,Integer page,Integer size);
	
}
