package com.fiuni.sd.bricks_management.dao.users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.bricks_management.domain.user.UserDomain;

@Repository
public interface IUserDAO extends CrudRepository<UserDomain, Integer>,
								  JpaRepository<UserDomain, Integer> {

	public Page<UserDomain> findAll(Pageable pageable);

	public Page<UserDomain> findByName(String name, Pageable pageable);

	public Page<UserDomain> findByLastName(String lastName, Pageable pageable);

	public Page<UserDomain> findByNameAndLastName(String name, String lastName, Pageable pageable);

}
