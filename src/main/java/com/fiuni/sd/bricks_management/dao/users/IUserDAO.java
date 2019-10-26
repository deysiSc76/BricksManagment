package com.fiuni.sd.bricks_management.dao.users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.bricks_management.domain.user.UserDomain;

@Repository
public interface IUserDAO extends CrudRepository<UserDomain, Integer> {	
	
	public Page<UserDomain> findAll(Pageable pageable);
	
}
