package com.fiuni.sd.bricks_management.dao.charge;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.fiuni.sd.bricks_management.domain.charge.ChargeDomain;

@Repository
public interface IChargeDAO extends CrudRepository<ChargeDomain, Integer> {
	
}
