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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiuni.sd.bricks_management.dto.personalDebt.PersonalDebtDTO;
import com.fiuni.sd.bricks_management.dto.personalDebt.PersonalDebtResult;
import com.fiuni.sd.bricks_management.service.personal_debt.IPersonalDebtService;
import com.fiuni.sd.bricks_management.utils.Setting;

@RestController
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
	
	@GetMapping(path = "/page/{page_num}/search")
	public PersonalDebtResult searchPersonalDebts(@PathVariable(value = "page_num") Integer pageNum,
			@RequestParam(value = "description", required = false) String description) {
		return personalDebtService.getByDescription(description, PageRequest.of(pageNum, Setting.PAGE_SIZE));
	}
	
	@PostMapping
	public PersonalDebtDTO save(@Valid @RequestBody PersonalDebtDTO personalDebt) {
		return personalDebtService.save(personalDebt);
	}
	
	@PutMapping("/{id}")
	public PersonalDebtDTO update(@PathVariable(value = "id") Integer id, @Valid @RequestBody PersonalDebtDTO personalDebt) {
		return personalDebtService.update(id, personalDebt);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void destroy(@PathVariable(value = "id") Integer id) {
		personalDebtService.delete(id);
	}
	
}
