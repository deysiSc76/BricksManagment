package com.fiuni.sd.bricks_management.service.payment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.bricks_management.dao.payment.IPaymentDAO;
import com.fiuni.sd.bricks_management.dao.paymentDetail.IPaymentDetailDao;
import com.fiuni.sd.bricks_management.domain.payment.PaymentDomain;
import com.fiuni.sd.bricks_management.domain.paymentDetail.PaymentDetailDomain;
import com.fiuni.sd.bricks_management.domain.user.UserDomain;
import com.fiuni.sd.bricks_management.dto.payment.FullPaymentDTO;
import com.fiuni.sd.bricks_management.dto.payment.PaymentDTO;
import com.fiuni.sd.bricks_management.dto.payment.PaymentResult;
import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailDTO;
import com.fiuni.sd.bricks_management.dto.user.UserDTO;
import com.fiuni.sd.bricks_management.dto.user.UserResult;
import com.fiuni.sd.bricks_management.service.base.BaseServiceImpl;
import com.fiuni.sd.bricks_management.service.paymentDetail.IPaymentDetailService;

@Service
public class PaymentSeviceImpl extends BaseServiceImpl<PaymentDTO, PaymentDomain, PaymentResult> 
implements IPaymentService {
	
	@Autowired
	private IPaymentDAO paymentDao;
	@Autowired
	private IPaymentDetailService paymentDetailService;
	
	@Override
	@Transactional
	public PaymentDTO save(PaymentDTO dto) {
		final PaymentDomain domain = convertDtoToDomain(dto);
		final PaymentDomain paymentDomain = paymentDao.save(domain);
		return convertDomainToDto(paymentDomain);
	}
	
	@Override
	@Transactional
	public FullPaymentDTO save(FullPaymentDTO fullPayment) {
		fullPayment.setPayment(save(fullPayment.getPayment()));
		fullPayment.getDetails().forEach(
				(PaymentDetailDTO det)->
					det.setPaymentId(fullPayment.getPayment().getId())
		);
		fullPayment.setDetails(
				paymentDetailService.save(fullPayment.getDetails()).getList()
		);
		return fullPayment;
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
		dto.setDocumentType(domain.getDocument_type());
		dto.setStamping(domain.getStamping());
		dto.setProviderId(domain.getProvider().getId());
		dto.setNumber(domain.getNumber());
		dto.setTotal(domain.getTotal());
		dto.setWorkId(domain.getWork().getId());
		
		return dto;
	}
	
	protected FullPaymentDTO convertDomainToFullDto(PaymentDomain domain) {
		final PaymentDTO paymentDto = new PaymentDTO();
		paymentDto.setId(domain.getId());
		paymentDto.setDate(domain.getDate());
		paymentDto.setBillType(domain.getBill_type());
		paymentDto.setDebtId(domain.getPersonalDebt().getId());
		paymentDto.setDocumentType(domain.getDocument_type());
		paymentDto.setStamping(domain.getStamping());
		paymentDto.setProviderId(domain.getProvider().getId());
		paymentDto.setNumber(domain.getNumber());
		paymentDto.setTotal(domain.getTotal());
		paymentDto.setWorkId(domain.getWork().getId());

		FullPaymentDTO dto = new FullPaymentDTO();
		dto.setPayment(paymentDto);		
		dto.setDetails(
			paymentDetailService.getByPaymentId(domain.getId()).getList()
		);		
		
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

