package com.fiuni.sd.bricks_management.dao.budgetConcept;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.bricks_management.domain.budgetConcept.BudgetConceptDomain;

@Repository
public interface IBudgetConceptDAO extends CrudRepository<BudgetConceptDomain, Integer>{

}
