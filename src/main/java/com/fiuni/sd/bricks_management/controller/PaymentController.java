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

import com.fiuni.sd.bricks_management.dto.payment.FullPaymentDTO;
import com.fiuni.sd.bricks_management.dto.payment.PaymentResult;
import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailDTO;
import com.fiuni.sd.bricks_management.service.payment.IPaymentService;
import com.fiuni.sd.bricks_management.service.paymentDetail.IPaymentDetailService;
import com.fiuni.sd.bricks_management.utils.Setting;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	@Autowired
	private IPaymentService paymentService;
	@Autowired
	private IPaymentDetailService paymentDetailService;
	
	@GetMapping(path = "/page/{page_num}")
	public PaymentResult getPayments(@PathVariable(value = "page_num") Integer pageNum) {
		return paymentService.getAll(PageRequest.of(pageNum, Setting.PAGE_SIZE));
	}
	
	@PostMapping()
	public FullPaymentDTO save(@Valid @RequestBody FullPaymentDTO dto) {
		return paymentService.save(dto);
	}
	
	@PutMapping("/{id}")
	public FullPaymentDTO update(@PathVariable(value = "id") Integer id, @Valid @RequestBody FullPaymentDTO dto) {
		for(PaymentDetailDTO detail : paymentDetailService.getByPaymentId(id).getList()){
			if(!dto.getDetails().contains(detail)) {
				paymentDetailService.delete(detail.getId());
			}
		}
		return paymentService.save(dto);
	}
	
	@GetMapping("/{id}")
	public FullPaymentDTO getById(@PathVariable(value = "id") Integer id) {
		return paymentService.getFullPayment(id);
	};

}
