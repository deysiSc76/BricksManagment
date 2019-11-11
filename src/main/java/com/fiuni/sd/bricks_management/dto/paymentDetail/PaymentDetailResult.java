package com.fiuni.sd.bricks_management.dto.paymentDetail;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.dto.base.BaseResult;

@XmlRootElement(name = "paymentDetailResult")
public class PaymentDetailResult extends BaseResult<PaymentDetailDTO>{
	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<PaymentDetailDTO> getPaymentDetails() {
		return getList();
	}

	public void setPaymentDetails(List<PaymentDetailDTO> dtos) {
		super.setList(dtos);
	}
}