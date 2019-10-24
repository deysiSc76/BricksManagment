package com.fiuni.sd.bricks_management.dao.role;

import org.springframework.data.repository.CrudRepository;
import com.fiuni.sd.bricks_management.domain.role.RoleDomain;;

public interface IRoleDao extends CrudRepository<RoleDomain, Integer> {

}
