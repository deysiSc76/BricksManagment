package com.fiuni.sd.bricks_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiuni.sd.bricks_management.dto.budget.BudgetDTO;
import com.fiuni.sd.bricks_management.service.budget.IBudgetService;

@RestController
@RequestMapping("/budgets")
public class BudgetController {
	@Autowired
	private IBudgetService budgetService;
	
	@PostMapping()
	public BudgetDTO save( @RequestBody BudgetDTO dto ) {
		return budgetService.save(dto);
	}
	
	@GetMapping("/{id}")
	public BudgetDTO getById(@PathVariable(name = "id") Integer id) {
		return budgetService.getById(id);
	}
	
	@PutMapping("/{id}")
	public BudgetDTO update(@RequestBody BudgetDTO dto ,@PathVariable(name= "id") Integer id) {
		return null;
	}
}
