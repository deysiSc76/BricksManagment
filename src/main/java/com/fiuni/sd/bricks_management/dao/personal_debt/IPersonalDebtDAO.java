package com.fiuni.sd.bricks_management.dao.personal_debt;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import com.fiuni.sd.bricks_management.domain.personalDebt.PersonalDebtDomain;

public interface IPersonalDebtDAO extends CrudRepository<PersonalDebtDomain, Integer> {

	public Page<PersonalDebtDomain> findAll(Pageable pageable);
	
	public Page<PersonalDebtDomain> findByDescription(String description, Pageable pageable);
	
}
