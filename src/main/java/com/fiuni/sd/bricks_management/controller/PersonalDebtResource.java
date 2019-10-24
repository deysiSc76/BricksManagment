package com.fiuni.sd.bricks_management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fiuni.sd.bricks_management.dto.personalDebt.PersonalDebtDTO;
import com.fiuni.sd.bricks_management.dto.personalDebt.PersonalDebtResult;
import com.fiuni.sd.bricks_management.service.personal_debt.IPersonalDebtService;
import com.fiuni.sd.bricks_management.utils.Setting;

@Controller
@RequestMapping("/personal_debts")
public class PersonalDebtResource {

	@Autowired
	private IPersonalDebtService personalDebtService;
	
	@GetMapping("/{id}")
	public PersonalDebtDTO getById(@PathVariable(value = "id") Integer personalDebtId) {
		return personalDebtService.getById(personalDebtId);
	}
	
	@GetMapping("/page/{page_num}")
	public PersonalDebtResult getPersonalDebts(@PathVariable(value = "page_num") Integer pageNum) {
		return personalDebtService.getAll(PageRequest.of(pageNum, Setting.PAGE_SIZE));
	}
	
	@PostMapping
	public PersonalDebtDTO save(@Valid @RequestBody PersonalDebtDTO personalDebt) {
		return personalDebtService.save(personalDebt);
	}
}
