package com.fiuni.sd.bricks_management.dao.budgetDetail;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.bricks_management.domain.budgetDetail.BudgetDetailDomain;

@Repository
public interface IBudgetDetailDAO extends CrudRepository<BudgetDetailDomain, Integer> {

}
