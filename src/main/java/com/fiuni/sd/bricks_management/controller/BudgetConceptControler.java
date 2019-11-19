package com.fiuni.sd.bricks_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiuni.sd.bricks_management.dto.budgetConcept.BudgetConceptDTO;
import com.fiuni.sd.bricks_management.dto.budgetConcept.BudgetConceptResult;
import com.fiuni.sd.bricks_management.service.budgetConcept.IBudgetConceptService;
import com.fiuni.sd.bricks_management.utils.Setting;

@RestController
@RequestMapping("/budgetConcept")
public class BudgetConceptControler {
	@Autowired
	private IBudgetConceptService budgetConceptService;
	@PostMapping()
	public BudgetConceptDTO save( @RequestBody BudgetConceptDTO dto ) {
		return budgetConceptService.save(dto);
	}
	@GetMapping("/{id}")
	public BudgetConceptDTO getById(@PathVariable(value = "id") Integer id) {
		return budgetConceptService.getById(id);
	}
	@GetMapping(path = "/page/{page_num}")
	public BudgetConceptResult getUsers(@PathVariable(value = "page_num") Integer pageNum) {
		return budgetConceptService.getAll(PageRequest.of(pageNum, Setting.PAGE_SIZE));
	}
	@PutMapping("/{id}")
	public BudgetConceptDTO update(@RequestBody BudgetConceptDTO budgetConceptDto ,@PathVariable(value= "id") Integer id) {
		return budgetConceptService.update(budgetConceptDto, id);
	}

}
