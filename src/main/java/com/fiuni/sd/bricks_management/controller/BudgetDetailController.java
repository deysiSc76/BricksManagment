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
import org.springframework.web.bind.annotation.RestController;

import com.fiuni.sd.bricks_management.dto.budgetDetail.BudgetDetailDTO;
import com.fiuni.sd.bricks_management.dto.budgetDetail.BudgetDetailResult;
import com.fiuni.sd.bricks_management.service.budgetDetail.IBudgetDetailService;
import com.fiuni.sd.bricks_management.utils.Setting;


@RestController
@RequestMapping("/budget_details")
public class BudgetDetailController {

	@Autowired
	private IBudgetDetailService budgetDetailService;
	
	@PostMapping()
	public BudgetDetailDTO save( @Valid @RequestBody BudgetDetailDTO dto ) {
		return budgetDetailService.save(dto);
	}
	
	@GetMapping("/{id}")
	public BudgetDetailDTO getById(@PathVariable(value = "id") Integer id) {
		return budgetDetailService.getById(id);
	}
	
	@GetMapping(path = "/page/{page_num}")
	public BudgetDetailResult getBudgets(@PathVariable(value = "page_num") Integer pageNum) {
		return budgetDetailService.getAll(PageRequest.of(pageNum, Setting.PAGE_SIZE));
	}
	
	@PutMapping("/{id}")
	public BudgetDetailDTO update(@RequestBody BudgetDetailDTO BudgetDetailDTO ,@PathVariable(value= "id") Integer id) {
		return budgetDetailService.update(id, BudgetDetailDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void destroy(@PathVariable(value = "id") Integer id) {
		budgetDetailService.delete(id);
	}
}
