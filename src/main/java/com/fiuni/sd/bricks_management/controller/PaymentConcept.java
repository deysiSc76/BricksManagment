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

import com.fiuni.sd.bricks_management.dto.paymentConcept.PaymentConceptDTO;
import com.fiuni.sd.bricks_management.service.paymentConcept.IPaymentConceptService;

@RestController
@RequestMapping("/paymentConcepts")
public class PaymentConcept {
	@Autowired
	private IPaymentConceptService paymentConceptService;
	
	@PostMapping()
	public PaymentConceptDTO save(@Valid @RequestBody PaymentConceptDTO dto) {
		return paymentConceptService.save(dto);
	}
	
	@PutMapping("/{id}")
	public PaymentConceptDTO update(@PathVariable(value = "id") Integer id, @Valid @RequestBody PaymentConceptDTO dto) {
		return paymentConceptService.save(dto);
	}
	
	@GetMapping("/{id}")
	public PaymentConceptDTO getById(@PathVariable(value = "id") Integer id) {
		return paymentConceptService.getById(id);
	};

}
