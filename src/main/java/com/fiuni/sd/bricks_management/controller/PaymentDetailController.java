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

import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailDTO;
import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailResult;
import com.fiuni.sd.bricks_management.service.paymentDetail.IPaymentDetailService;
import com.fiuni.sd.bricks_management.utils.Setting;

@RestController
@RequestMapping("/payment_details")
public class PaymentDetailController {


	@Autowired
	private IPaymentDetailService budgetService;
	
	@PostMapping()
	public PaymentDetailDTO save( @Valid @RequestBody PaymentDetailDTO dto ) {
		return budgetService.save(dto);
	}
	
	@GetMapping("/{id}")
	public PaymentDetailDTO getById(@PathVariable(value = "id") Integer id) {
		return budgetService.getById(id);
	}
	
	@GetMapping(path = "/page/{page_num}")
	public PaymentDetailResult getBudgets(@PathVariable(value = "page_num") Integer pageNum) {
		return budgetService.getAll(PageRequest.of(pageNum, Setting.PAGE_SIZE));
	}
	
	@PutMapping("/{id}")
	public PaymentDetailDTO update(@RequestBody PaymentDetailDTO PaymentDetailDTO ,@PathVariable(value= "id") Integer id) {
		return budgetService.save(PaymentDetailDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void destroy(@PathVariable(value = "id") Integer id) {
		budgetService.delete(id);
	}
	
	@RequestMapping(value = "/{budget_id}/budget_details/{detail_id}")
	public void destroyDetail(@PathVariable(value = "detail_id") Integer id) {
		budgetService.delete(id);
	}
}
