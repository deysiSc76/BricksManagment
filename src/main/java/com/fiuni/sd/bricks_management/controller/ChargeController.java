package com.fiuni.sd.bricks_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiuni.sd.bricks_management.dto.ChargeDTO;
import com.fiuni.sd.bricks_management.service.charge.IChargeService;

@RestController
@RequestMapping("/charges")
public class ChargeController {
	@Autowired(required = true) 
	private IChargeService chargeService;
	
	@GetMapping("/{id}")
	public ChargeDTO getById(@PathVariable(value = "id") Integer id) {
		return chargeService.getById(id);
	};
}
