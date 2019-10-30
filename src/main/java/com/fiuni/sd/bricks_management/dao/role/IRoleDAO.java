package com.fiuni.sd.bricks_management.dao.role;

import org.springframework.data.repository.CrudRepository; 
import org.springframework.stereotype.Repository;

import com.fiuni.sd.bricks_management.domain.role.RoleDomain;;

@Repository
public interface IRoleDAO extends CrudRepository<RoleDomain, Integer> {
	
}
