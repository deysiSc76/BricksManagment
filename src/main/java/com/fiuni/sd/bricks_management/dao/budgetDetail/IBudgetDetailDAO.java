package com.fiuni.sd.bricks_management.dao.budgetDetail;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.bricks_management.domain.budgetDetail.BudgetDetailDomain;

@Repository
public interface IBudgetDetailDAO extends CrudRepository<BudgetDetailDomain, Integer> {
	public Page<BudgetDetailDomain> findAll(Pageable pageable);
	
}
