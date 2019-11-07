package com.fiuni.sd.bricks_management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiuni.sd.bricks_management.dto.paymentConcept.PaymentConceptDTO;
import com.fiuni.sd.bricks_management.dto.paymentConcept.PaymentConceptResult;
import com.fiuni.sd.bricks_management.service.paymentConcept.IPaymentConceptService;
import com.fiuni.sd.bricks_management.utils.Setting;

@RestController
@RequestMapping("/payment_concepts")
public class PaymentConceptController {
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

	@GetMapping("/page/{page_num}")
	public PaymentConceptResult getAll(@PathVariable(value = "page_num") Integer pageNum) {
		return paymentConceptService.getAll(PageRequest.of(pageNum, Setting.PAGE_SIZE));
	}
	
	@GetMapping("/page/{page_num}/search")
	public PaymentConceptResult getByName(@PathVariable(value = "page_num") Integer pageNum,
										  @RequestParam(value = "name", required = false) String name) {
		if (name == null) {
			return paymentConceptService.getAll(PageRequest.of(pageNum, Setting.PAGE_SIZE));
		}
		return paymentConceptService.getByName(name, PageRequest.of(pageNum, Setting.PAGE_SIZE));
	}
	
}
