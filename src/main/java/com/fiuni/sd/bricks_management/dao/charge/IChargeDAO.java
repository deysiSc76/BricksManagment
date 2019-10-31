package com.fiuni.sd.bricks_management.dao.charge;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.bricks_management.domain.charge.ChargeDomain;

@Repository
public interface IChargeDAO extends CrudRepository<ChargeDomain, Integer> {
	public Page<ChargeDomain> findAll(Pageable pageable);
}
