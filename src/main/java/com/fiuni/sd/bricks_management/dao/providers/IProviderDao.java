package com.fiuni.sd.bricks_management.dao.providers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.bricks_management.domain.provider.ProviderDomain;

@Repository
public interface IProviderDao extends  CrudRepository<ProviderDomain, Integer>, 
										JpaRepository<ProviderDomain, Integer> {

	public Page<ProviderDomain> findAll(Pageable pageable);
	
	public Page<ProviderDomain> findByBussinessName(String bussinessName, Pageable pageable);
	
	public Page<ProviderDomain> findByRuc(String ruc, Pageable pageable);
	
	public Page<ProviderDomain> findByBussinessNameAndRuc(String bussinessName, String ruc, Pageable pageable);
}
