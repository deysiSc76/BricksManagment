package com.fiuni.sd.bricks_management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@GetMapping("/by-date/{date}/{page_num}")
	public ChargeResult getByDate(@PathVariable(value = "date") String date, @PathVariable(value = "page_num") Integer pageNum) {
		return chargeService.getByDate(date, PageRequest.of(pageNum, Setting.PAGE_SIZE));
	}
	
	@PutMapping("/{id}")
	public ChargeDTO update(@Valid @RequestBody ChargeDTO dto, @PathVariable(value="id") Integer id) {
		return chargeService.update(dto, id);
	}
	
	@GetMapping("/page/{page_num}")
	public ChargeResult getAll(@PathVariable(value = "page_num") Integer pageNum) {
		return chargeService.getAll(PageRequest.of(pageNum, Setting.PAGE_SIZE));
	}
	@GetMapping(path = "/page/{page_num}/search")
	public ChargeResult searchCharges(@PathVariable(value = "page_num") Integer pageNum,
									  @RequestParam(value = "date", required = false) String date) {
		if (date != null) {
			return chargeService.getByDate(date, PageRequest.of(pageNum, Setting.PAGE_SIZE));
		}
		return chargeService.getAll(PageRequest.of(pageNum, Setting.PAGE_SIZE));
	}
}
