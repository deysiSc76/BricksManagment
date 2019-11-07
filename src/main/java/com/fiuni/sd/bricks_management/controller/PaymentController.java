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

import com.fiuni.sd.bricks_management.dto.payment.PaymentDTO;
import com.fiuni.sd.bricks_management.dto.payment.PaymentResult;
import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailDTO;
import com.fiuni.sd.bricks_management.service.payment.IPaymentService;
import com.fiuni.sd.bricks_management.utils.Setting;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	@Autowired
	private IPaymentService paymentService;
	
	@PostMapping()
	public PaymentDTO save(@Valid @RequestBody PaymentDTO dto) {
		return paymentService.save(dto);
	}
	
	@GetMapping("/{id}")
	public PaymentDTO getById(@PathVariable(value = "id") Integer id) {
		return paymentService.getById(id);
	}
	
	@GetMapping(path = "/page/{page_num}")
	public PaymentResult getPayments(@PathVariable(value = "page_num") Integer pageNum) {
		return paymentService.getAll(PageRequest.of(pageNum, Setting.PAGE_SIZE));
	}

	@GetMapping(path = "/page/{page_num}/search")
	public PaymentResult searchPayments(@PathVariable(value = "page_num") Integer pageNum,
										@RequestParam(value = "number") String number) {
		return paymentService.getByNumber(Integer.valueOf(number), PageRequest.of(pageNum, Setting.PAGE_SIZE));
	}
	
	@PutMapping("/{id}")
	public PaymentDTO update(@PathVariable(value = "id") Integer id,
							 @Valid @RequestBody PaymentDTO payment) {
		return paymentService.update(id, payment);
	}
	
	@PutMapping(path = "/{payment_id}/payment_details/{detail_id}")
	public PaymentDetailDTO updateDetail(@PathVariable(value = "detail_id") Integer id,
			 							 @Valid @RequestBody PaymentDetailDTO detail) {
		return paymentService.updateDetail(id, detail);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void destroy(@PathVariable(value = "id") Integer id) {
		paymentService.delete(id);
	}
	
	@RequestMapping(path = "/{payment_id}/payment_details/{detail_id}", method = RequestMethod.DELETE)
	public void destroyDetail(@PathVariable(value = "detail_id") Integer id) {
		paymentService.deleteDetail(id);
	}
	
	/*@PutMapping("/{id}")
	public FullPaymentDTO update(@PathVariable(value = "id") Integer id, @Valid @RequestBody FullPaymentDTO dto) {
		for(PaymentDetailDTO detail : paymentDetailService.getByPaymentId(id).getList()){
			if(!dto.getDetails().contains(detail)) {
				paymentDetailService.delete(detail);
			}
		}
		return paymentService.save(dto);
	}*/
	
}