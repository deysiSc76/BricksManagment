package com.fiuni.sd.bricks_management.dao.providers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.fiuni.sd.bricks_management.domain.provider.ProviderDomain;

public interface IProviderDao extends  CrudRepository<ProviderDomain, Integer>{

	//public List<ProviderDomain> find(String text,Integer page,Integer size);
	public Page<ProviderDomain> findAll(Pageable pageable);
}
