package com.fiuni.sd.bricks_management.dao.base;

import java.util.List;

import com.fiuni.sd.bricks_management.domain.base.BaseDomain;

public interface IBaseDao <D extends BaseDomain> {

	public D save(D domain);

	public D getById(Integer domainId);

	public List<D> findAll();

	public List<D> findAll(Integer page,Integer size);
	
	public D update(D domain);
	
	public void delete(D domain);
}
