package com.fiuni.sd.bricks_management.dao.paymentDetail;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.bricks_management.domain.paymentDetail.PaymentDetailDomain;

@Repository
public interface IPaymentDetailDao extends CrudRepository<PaymentDetailDomain, Integer> {
	public Page<PaymentDetailDomain> findAll(Pageable pageable);

	@Query("FROM PaymentDetailDomain WHERE payment_id = :paymentId")
	public List<PaymentDetailDomain> findByPaymentId(@Param("paymentId") Integer paymentId);
}
