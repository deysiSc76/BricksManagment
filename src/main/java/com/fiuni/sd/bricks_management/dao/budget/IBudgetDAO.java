package com.fiuni.sd.bricks_management.dao.budget;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.bricks_management.domain.budget.BudgetDomain;

@Repository
public interface IBudgetDAO extends CrudRepository<BudgetDomain, Integer>{

}
