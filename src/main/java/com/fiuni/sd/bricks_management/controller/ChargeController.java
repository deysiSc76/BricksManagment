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
import org.springframework.web.bind.annotation.RestController;

import com.fiuni.sd.bricks_management.dto.charge.ChargeDTO;
import com.fiuni.sd.bricks_management.dto.charge.ChargeResult;
import com.fiuni.sd.bricks_management.service.charge.IChargeService;
import com.fiuni.sd.bricks_management.utils.Setting;

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
	}
	
	@PutMapping("/{id}")
	public ChargeDTO update(@Valid @RequestBody ChargeDTO dto, @PathVariable(value="id") Integer id) {
		return chargeService.update(dto, id);
	}
	
	@GetMapping("/page/{page_num}")
	public ChargeResult getAll(@PathVariable(value = "page_num") Integer pageNum) {
		return chargeService.getAll(PageRequest.of(pageNum, Setting.PAGE_SIZE));
	}
}
