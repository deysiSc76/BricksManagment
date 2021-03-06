package com.fiuni.sd.bricks_management.service.charge;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fiuni.sd.bricks_management.dao.budget.IBudgetDAO;
import com.fiuni.sd.bricks_management.dao.charge.IChargeDAO;
import com.fiuni.sd.bricks_management.dao.users.IUserDAO;
import com.fiuni.sd.bricks_management.domain.charge.ChargeDomain;
import com.fiuni.sd.bricks_management.dto.charge.ChargeDTO;
import com.fiuni.sd.bricks_management.dto.charge.ChargeResult;
import com.fiuni.sd.bricks_management.service.base.BaseServiceImpl;

@Service
public class ChargeServiceImpl extends BaseServiceImpl<ChargeDTO, ChargeDomain, ChargeResult> 
	implements IChargeService{
	@Autowired
	private IChargeDAO chargeDAO;
	@Autowired
	private IBudgetDAO budgetDAO;
	@Autowired
	private IUserDAO userDAO;
	
	@Override
	@Transactional
	public ChargeDTO save(ChargeDTO dto) {
		final ChargeDomain domain = convertDtoToDomain(dto);
		final ChargeDomain chargeDomain = chargeDAO.save(domain);
		return convertDomainToDto(chargeDomain);
	}

	@Override
	@Transactional
	public ChargeDTO getById(Integer id) {
		final ChargeDomain domain = chargeDAO.findById(id).get();
		return convertDomainToDto(domain);
	}
	
	@Override
	@Transactional
	public ChargeDTO update(ChargeDTO dto, Integer id) {
		final ChargeDTO toUpdate = convertDomainToDto(chargeDAO.findById(id).get());
		toUpdate.setAmount(dto.getAmount());
		toUpdate.setBudgetId(dto.getBudgetId());
		toUpdate.setClientId(dto.getClientId());
		toUpdate.setDate(dto.getDate());
		toUpdate.setDescription(dto.getDescription());
		return convertDomainToDto( chargeDAO.save( convertDtoToDomain(toUpdate) ) );
	}
	
	@Override
	@Transactional
	public ChargeResult getAll(Pageable pageable) {
		final List<ChargeDTO> chargeDtos = new ArrayList<>();
		Page<ChargeDomain> resultDomains = chargeDAO.findAll(pageable);
		resultDomains.forEach(charge -> chargeDtos.add(convertDomainToDto(charge)));
		
		final ChargeResult chargeResult = new ChargeResult();
		chargeResult.setCharges(chargeDtos);
		return chargeResult;
	}
	
	/* Retorna una lista de domains a partir de otra de dtos */
	public List<ChargeDomain> convertToDomainList( List<ChargeDTO> dtoList ) {
		ArrayList<ChargeDomain> domains = new ArrayList<>();
		dtoList.forEach( dto -> domains.add( convertDtoToDomain(dto) ) );
		return domains;
	}
	
	/* Retorna una lista de dtos a partir de otra de domains */
	public List<ChargeDTO> convertToDtoList( List<ChargeDomain> domainList ){
		ArrayList<ChargeDTO> dtos = new ArrayList<>();
		domainList.forEach( domain -> dtos.add( convertDomainToDto(domain) ) );
		return dtos;
	}

	@Override
	protected ChargeDTO convertDomainToDto(ChargeDomain domain) {
		final ChargeDTO dto = new ChargeDTO();
		dto.setAmount(domain.getAmount());
		dto.setBudgetId(domain.getBudget().getId());
		dto.setClientId(domain.getClient().getId());
		dto.setDate(domain.getDate());
		dto.setId(domain.getId());
		return dto;
	}

	@Override
	protected ChargeDomain convertDtoToDomain(ChargeDTO dto) {
		final ChargeDomain domain = new ChargeDomain();
		domain.setAmount(dto.getAmount());
		domain.setBudget(budgetDAO.findById(dto.getBudgetId()).get());
		domain.setClient(userDAO.findById(dto.getClientId()).get());
		domain.setDate(dto.getDate());
		domain.setDescription(dto.getDescription());
		domain.setId(dto.getId());
		return domain;
	}
	@Override
	public ChargeResult getByDate(String date, Pageable pageable) {
		final List<ChargeDTO> charges = new ArrayList<>();
		Page<ChargeDomain> results = chargeDAO.findByDate(date, pageable);
		results.forEach(charge -> charges.add(convertDomainToDto(charge)));
		
		final ChargeResult chargeResult = new ChargeResult();
		chargeResult.setCharges(charges);
		return chargeResult;
	}
}
