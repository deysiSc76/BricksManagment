package com.fiuni.sd.bricks_management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiuni.sd.bricks_management.dto.budgetDetail.BudgetDetailDTO;
import com.fiuni.sd.bricks_management.dto.budgetDetail.BudgetDetailResult;
import com.fiuni.sd.bricks_management.dto.charge.ChargeDTO;
import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailResult;
import com.fiuni.sd.bricks_management.service.budget.IBudgetService;
import com.fiuni.sd.bricks_management.service.budgetDetail.IBudgetDetailService;

@RestController
@RequestMapping("/BudgetDetail")
public class BudgetDetailsController {
	@Autowired
	private IBudgetDetailService budgetDetailService;
	@PostMapping()
	public BudgetDetailDTO save(@Valid @RequestBody BudgetDetailDTO dto) {
		return budgetDetailService.save(dto);
	}
	@GetMapping("/{id}")
	public BudgetDetailDTO getById(@PathVariable(value = "id") Integer id) {
		return budgetDetailService.getById(id);
	}


}
