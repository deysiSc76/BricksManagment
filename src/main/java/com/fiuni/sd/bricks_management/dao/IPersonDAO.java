package com.fiuni.sd.bricks_management.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.bricks_management.domain.PersonDomain;

@Repository
public interface IPersonDAO extends CrudRepository<PersonDomain, Integer> {	
	
}
