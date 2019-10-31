package com.fiuni.sd.bricks_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailDTO;
import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailResult;
import com.fiuni.sd.bricks_management.service.paymentDetail.IPaymentDetailService;

@RestController
@RequestMapping("/payment_details")
public class PaymentDetailController {
	@Autowired
	private IPaymentDetailService paymentDetailService;
	
	@GetMapping("/{id}")
	public PaymentDetailDTO getById(@PathVariable(value = "id") Integer id) {
		return paymentDetailService.getById(id);
	}
	
	@GetMapping("/from_payment/{id}")
	public PaymentDetailResult getByPaymentId(@PathVariable(value = "id") Integer id) {
		return paymentDetailService.getByPaymentId(id);
	}

}