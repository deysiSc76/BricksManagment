package com.fiuni.sd.bricks_management.dao.budgetConcept;

import java.util.List; 

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.bricks_management.domain.budgetConcept.BudgetConceptDomain;
import com.fiuni.sd.bricks_management.dto.budgetConcept.BudgetConceptDTO;
import com.fiuni.sd.bricks_management.dto.budgetConcept.BudgetConceptResult;

@Repository
public interface IBudgetConceptDAO extends CrudRepository<BudgetConceptDomain, Integer>{
	
	public Page<BudgetConceptDomain> findAll(Pageable pageable);
	
	public BudgetConceptResult save(List<BudgetConceptDTO> budgetConcepts);

}
