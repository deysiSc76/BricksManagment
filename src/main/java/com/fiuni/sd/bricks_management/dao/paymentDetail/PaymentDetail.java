package com.fiuni.sd.bricks_management.dao.paymentDetail;

import org.springframework.data.repository.CrudRepository;
import com.fiuni.sd.bricks_management.domain.paymentDetail.PaymentDetailDomain;

public interface PaymentDetail extends CrudRepository<PaymentDetailDomain, Integer> {

}
