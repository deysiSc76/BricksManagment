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

import com.fiuni.sd.bricks_management.dto.budget.BudgetDTO;
import com.fiuni.sd.bricks_management.dto.budget.BudgetResult;
import com.fiuni.sd.bricks_management.dto.budgetDetail.BudgetDetailDTO;
import com.fiuni.sd.bricks_management.service.budget.IBudgetService;
import com.fiuni.sd.bricks_management.utils.Setting;

@RestController
@RequestMapping("/budgets")
public class BudgetController {
	@Autowired
	private IBudgetService budgetService;
	
	@PostMapping()
	public BudgetDTO save( @Valid @RequestBody BudgetDTO dto ) {
		return budgetService.save(dto);
	}
	
	@GetMapping("/{id}")
	public BudgetDTO getById(@PathVariable(value = "id") Integer id) {
		return budgetService.getById(id);
	}
	
	@GetMapping(path = "/page/{page_num}")
	public BudgetResult getBudgets(@PathVariable(value = "page_num") Integer pageNum) {
		return budgetService.getAll(PageRequest.of(pageNum, Setting.PAGE_SIZE));
	}
	
	@PutMapping("/{id}")
	public BudgetDTO update(@RequestBody BudgetDTO budgetDto ,@PathVariable(value= "id") Integer id) {
		return budgetService.update(budgetDto, id);
	}
	
	@PutMapping("/{budget_id}/budget_details/{detail_id}")
	public BudgetDetailDTO updateDetail(@PathVariable(value = "detail_id") Integer id, 
										@RequestBody BudgetDetailDTO detailDto) {
		return budgetService.updateDetail(id, detailDto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void destroy(@PathVariable(value = "id") Integer id) {
		budgetService.delete(id);
	}
	
	@RequestMapping(value = "/{budget_id}/budget_details/{detail_id}")
	public void destroyDetail(@PathVariable(value = "detail_id") Integer id) {
		budgetService.deleteDetail(id);
	}
}
