package com.fiuni.sd.bricks_management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiuni.sd.bricks_management.dto.payment.FullPaymentDTO;
import com.fiuni.sd.bricks_management.dto.payment.PaymentDTO;
import com.fiuni.sd.bricks_management.dto.paymentConcept.FullPaymentConceptDTO;
import com.fiuni.sd.bricks_management.dto.paymentConcept.PaymentConceptDTO;
import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailDTO;
import com.fiuni.sd.bricks_management.service.payment.IPaymentService;
import com.fiuni.sd.bricks_management.service.paymentConcept.IPaymentConceptService;
import com.fiuni.sd.bricks_management.service.paymentDetail.IPaymentDetailService;

@RestController
@RequestMapping("/paymentConcepts")
public class PaymentConcept {
	@Autowired
	private IPaymentConceptService paymentConceptService;
	@Autowired
	private IPaymentDetailService paymentDetailService;
	
	@PostMapping()
	public FullPaymentConceptDTO save(@Valid @RequestBody FullPaymentConceptDTO dto) {
		return paymentConceptService.save(dto);
	}
	
	@PutMapping("/{id}")
	public FullPaymentConceptDTO update(@PathVariable(value = "id") Integer id, @Valid @RequestBody FullPaymentConceptDTO dto) {
		for(PaymentDetailDTO detail : paymentDetailService.getByPaymentId(id).getList()){
			if(!dto.getDetails().contains(detail)) {
				paymentDetailService.delete(detail);
			}
		}
		return paymentConceptService.save(dto);
	}
	
	@GetMapping("/{id}")
	public PaymentConceptDTO getById(@PathVariable(value = "id") Integer id) {
		return paymentConceptService.getById(id);
	};

}
