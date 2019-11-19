package com.fiuni.sd.bricks_management.dao.budgetDetail;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.bricks_management.domain.budgetDetail.BudgetDetailDomain;
import com.fiuni.sd.bricks_management.domain.paymentDetail.PaymentDetailDomain;

@Repository
public interface IBudgetDetailDAO extends CrudRepository<BudgetDetailDomain, Integer> {
	public Page<BudgetDetailDomain> findAll(Pageable pageable);
	@Query("FROM BudgetDetailDomain WHERE budget_id = :budgetId")
	public List<BudgetDetailDomain> findByBudgetId(@Param("budgetId") Integer budgetId);
	
}
