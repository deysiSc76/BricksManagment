package com.fiuni.sd.bricks_management.service.payment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.bricks_management.dao.payment.IPaymentDAO;
import com.fiuni.sd.bricks_management.dao.paymentConcept.IPaymentConceptDao;
import com.fiuni.sd.bricks_management.dao.paymentDetail.IPaymentDetailDao;
import com.fiuni.sd.bricks_management.dao.personal_debt.IPersonalDebtDAO;
import com.fiuni.sd.bricks_management.dao.providers.IProviderDao;
import com.fiuni.sd.bricks_management.dao.work.IWorkDAO;
import com.fiuni.sd.bricks_management.domain.payment.PaymentDomain;
import com.fiuni.sd.bricks_management.domain.paymentDetail.PaymentDetailDomain;
import com.fiuni.sd.bricks_management.dto.payment.PaymentDTO;
import com.fiuni.sd.bricks_management.dto.payment.PaymentResult;
import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailDTO;
import com.fiuni.sd.bricks_management.service.base.BaseServiceImpl;

@Service
public class PaymentServiceImpl extends BaseServiceImpl<PaymentDTO, PaymentDomain, PaymentResult> 
implements IPaymentService {
	
	@Autowired
	private IPaymentDAO paymentDao;
	@Autowired
	private IPaymentDetailDao paymentDetailDao;
	@Autowired
	private IPaymentConceptDao paymentConceptDao;
	@Autowired
	private IPersonalDebtDAO personalDebtDao;
	@Autowired
	private IProviderDao providerDao;
	@Autowired
	private IWorkDAO workDao;
	
	@Override
	@Transactional
	public PaymentDTO save(PaymentDTO dto) {
		List<PaymentDetailDTO> detailsDto = dto.getDetails();
		final PaymentDomain payment = convertDtoToDomain(dto);
		paymentDao.save(payment);
		
		detailsDto.forEach(detail -> detail.setPaymentId(payment.getId()));
		detailsDto.forEach(detail -> detail.setPaymentRelatedId(payment.getId()));
		List<PaymentDetailDomain> detailsDomain = convertToDetailDomainList(detailsDto);
		detailsDomain.forEach(domain -> paymentDetailDao.save(domain));
		payment.setPayment_details(detailsDomain);
		
		return convertDomainToDto(payment);
	}
	
	@Override
	public PaymentDTO getById(Integer id) {
		// nuevo full payment detail dto
		final PaymentDomain domain = paymentDao.findById(id).get();
		return convertDomainToDto(domain);
	}
	
	@Override
	public PaymentResult getAll(Pageable pageable) {
		final List<PaymentDTO> dtos = new ArrayList<>();
		Page<PaymentDomain> paymentResults = paymentDao.findAll(pageable);
		paymentResults.forEach(domain -> dtos.add(convertDomainToDto(domain)));
		
		final PaymentResult paymentResult = new PaymentResult();
		paymentResult.setList(dtos);
		return paymentResult;
	}
	
	@Override
	public PaymentResult getByNumber(int number, Pageable pageable) {
		Page<PaymentDomain> payments = paymentDao.findByNumber(number, pageable);
		List<PaymentDTO> dtos = new ArrayList<>();
		payments.forEach(payment -> dtos.add(convertDomainToDto(payment)));
		
		final PaymentResult paymentResult = new PaymentResult();
		paymentResult.setList(dtos);
		return paymentResult;
	}
	
	public void delete(Integer id) {
		paymentDao.deleteById(id);
	}
	
	@Override
	public void deleteDetail(Integer id) {
		paymentDetailDao.deleteById(id);
	}

	@Override
	public PaymentDTO update(Integer id, PaymentDTO payment) {
		final PaymentDTO toUpdate = convertDomainToDto(paymentDao.findById(id).get());
		toUpdate.setBillType(payment.getBillType());
		toUpdate.setDate(payment.getDate());
		toUpdate.setDocumentType(payment.getDocumentType());
		toUpdate.setNumber(payment.getNumber());
		toUpdate.setPersonalDebtId(payment.getPersonalDebtId());
		toUpdate.setProviderId(payment.getProviderId());
		toUpdate.setStamping(payment.getStamping());
		toUpdate.setTotal(payment.getTotal());
		toUpdate.setWorkId(payment.getWorkId());
		toUpdate.setDetails(payment.getDetails());
		
		save(toUpdate);
		
		return toUpdate;
	}

	@Override
	@Transactional
	public PaymentDetailDTO updateDetail(Integer id, PaymentDetailDTO paymentDetail) {
		final PaymentDetailDTO toUpdate = convertToDetailDto(paymentDetailDao.findById(id).get());
		toUpdate.setPaymentConceptId(paymentDetail.getPaymentConceptId());
		toUpdate.setQuantity(paymentDetail.getQuantity());
		toUpdate.setUnitPrice(paymentDetail.getUnitPrice());
		
		paymentDetailDao.save(convertToDetailDomain(toUpdate));
		
		return toUpdate;
	}
	
	@Override
	protected PaymentDTO convertDomainToDto(PaymentDomain domain) {
		final PaymentDTO dto = new PaymentDTO();
		dto.setBillType(domain.getBill_type());
		dto.setDate(domain.getDate());
		dto.setDocumentType(domain.getDocument_type());
		dto.setId(domain.getId());
		dto.setNumber(domain.getNumber());
		dto.setPersonalDebtId(domain.getPersonalDebt().getId());
		dto.setProviderId(domain.getProvider().getId());
		dto.setStamping(domain.getStamping());
		dto.setTotal(domain.getTotal());
		dto.setWorkId(domain.getWork().getId());
		dto.setDetails(convertToDetailDtoList(domain.getPayment_details()));
		
		return dto;
	}
	
	@Override
	protected PaymentDomain convertDtoToDomain(PaymentDTO dto) { 
		final PaymentDomain domain = new PaymentDomain();
		domain.setBill_type(dto.getBillType());
		domain.setDate(dto.getDate());
		domain.setDocument_type(dto.getDocumentType());
		domain.setId(dto.getId());
		domain.setNumber(dto.getNumber());
		domain.setPersonalDebt(personalDebtDao.findById(dto.getPersonalDebtId()).get());
		domain.setProvider(providerDao.findById(dto.getProviderId()).get());
		domain.setStamping(dto.getStamping());
		domain.setTotal(dto.getTotal());
		domain.setWork(workDao.findById(dto.getWorkId()).get());
		
		return domain;
	}

	
	private PaymentDetailDomain convertToDetailDomain(PaymentDetailDTO dto) {
		final PaymentDetailDomain domain = new PaymentDetailDomain();
		domain.setId(dto.getId());
		domain.setPayment(paymentDao.findById(dto.getPaymentId()).get());
		domain.setPayment_concept(paymentConceptDao.findById(dto.getPaymentConceptId()).get());
		domain.setPayment_related(paymentDao.findById(dto.getPaymentRelatedId()).get());
		domain.setQuantity(dto.getQuantity());
		domain.setUnit_price(dto.getUnitPrice());
		
		return domain;
	}
	
	private PaymentDetailDTO convertToDetailDto(PaymentDetailDomain domain) {
		final PaymentDetailDTO dto = new PaymentDetailDTO();
		dto.setId(domain.getId());
		dto.setPaymentConceptId(domain.getPayment_concept().getId());
		dto.setPaymentId(domain.getPayment().getId());
		dto.setPaymentRelatedId(domain.getPayment_related().getId());
		dto.setQuantity(domain.getQuantity());
		dto.setUnitPrice(domain.getUnit_price());
		
		return dto;
	}
	
	private List<PaymentDetailDomain> convertToDetailDomainList(List<PaymentDetailDTO> dtos) {
		final List<PaymentDetailDomain> domains = new ArrayList<>();
		dtos.forEach(dto -> domains.add(convertToDetailDomain(dto)));
		return domains;
	}
	
	private List<PaymentDetailDTO> convertToDetailDtoList(List<PaymentDetailDomain> domains) {
		final List<PaymentDetailDTO> dtos = new ArrayList<>();
		domains.forEach(domain -> dtos.add(convertToDetailDto(domain)));
		return dtos;
	}
	
}