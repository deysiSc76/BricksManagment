package com.fiuni.sd.bricks_management.service.payment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.bricks_management.dao.payment.PaymentDAO;
import com.fiuni.sd.bricks_management.domain.payment.PaymentDomain;
import com.fiuni.sd.bricks_management.domain.user.UserDomain;
import com.fiuni.sd.bricks_management.dto.payment.PaymentDTO;
import com.fiuni.sd.bricks_management.dto.payment.PaymentResult;
import com.fiuni.sd.bricks_management.dto.user.UserDTO;
import com.fiuni.sd.bricks_management.dto.user.UserResult;
import com.fiuni.sd.bricks_management.service.base.BaseServiceImpl;

public class PaymentSevice extends BaseServiceImpl<PaymentDTO, PaymentDomain, PaymentResult> 
implements IPaymentService {
	
	@Autowired
	private PaymentDAO paymentDao;
	
	@Override
	@Transactional
	public PaymentDTO save(PaymentDTO dto) {
		final PaymentDomain domain = convertDtoToDomain(dto);
		final PaymentDomain paymentDomain = paymentDao.save(domain);
		return convertDomainToDto(paymentDomain);
	}
	@Override
	public PaymentDTO getById(Integer id) {
		// nuevo full payment detail dto
		final PaymentDomain domain = paymentDao.findById(id).get();
		return convertDomainToDto(domain);
	}
	@Override
	public PaymentResult getAll(Pageable pageable) {
		final List<PaymentDTO> payments = new ArrayList<>();
		final PaymentResult paymentResult = new PaymentResult();
		paymentResult.setList(payments);
		return paymentResult;
	}
	public void delete(Integer id) {
		paymentDao.deleteById(id);
		
	}
	
	@Override
	protected PaymentDTO convertDomainToDto(PaymentDomain domain) {
		final PaymentDTO dto = new PaymentDTO();
		dto.setId(domain.getId());
		dto.setDate(domain.getDate());
		dto.setBillType(domain.getBill_type());
		dto.setDebtId(domain.getPersonalDebt().getId());
		dto.setDetails(domain.getPayment_details());
		dto.setDocumentType(domain.getDocument_type());
		dto.setStamping(domain.getStamping());
		dto.setProviderId(domain.getProvider().getId());
		dto.setNumber(domain.getNumber());
		dto.setTotal(domain.getTotal());
		dto.setWorkId(domain.getWork().getId());
		
		return dto;
	}

	@Override
	protected PaymentDomain convertDtoToDomain(PaymentDTO dto) {
		final PaymentDomain domain = new PaymentDomain();
		domain.setId(dto.getId());
		domain.setDate(dto.getDate());
		domain.setDocument_type(dto.getDocumentType());
		domain.setBill_type(domain.getBill_type());
		return domain;
	}

}

