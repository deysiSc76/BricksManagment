package com.fiuni.sd.bricks_management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiuni.sd.bricks_management.dto.charge.ChargeDTO;
import com.fiuni.sd.bricks_management.service.charge.IChargeService;

@RestController
@RequestMapping("/charges")
public class ChargeController {
	@Autowired
	private IChargeService chargeService;
	
	@PostMapping()
	public ChargeDTO save(@Valid @RequestBody ChargeDTO dto) {
		return chargeService.save(dto);
	}
	
	@GetMapping("/{id}")
	public ChargeDTO getById(@PathVariable(value = "id") Integer id) {
		return chargeService.getById(id);
	};
}
