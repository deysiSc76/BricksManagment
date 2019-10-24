package com.fiuni.sd.bricks_management.service.personal_debt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fiuni.sd.bricks_management.dao.personal_debt.IPersonalDebtDAO;
import com.fiuni.sd.bricks_management.domain.personalDebt.PersonalDebtDomain;
import com.fiuni.sd.bricks_management.dto.personalDebt.PersonalDebtDTO;
import com.fiuni.sd.bricks_management.dto.personalDebt.PersonalDebtResult;
import com.fiuni.sd.bricks_management.service.base.BaseServiceImpl;

@Service
public class PersonalDebtServiceImpl extends BaseServiceImpl<PersonalDebtDTO, PersonalDebtDomain, PersonalDebtResult>
	implements IPersonalDebtService {

	@Autowired
	private IPersonalDebtDAO personalDebtDao;

	@Override
	public PersonalDebtDTO save(PersonalDebtDTO dto) {
		final PersonalDebtDomain domain = convertDtoToDomain(dto);
		final PersonalDebtDomain personalDebtDomain = personalDebtDao.save(domain);
		return convertDomainToDto(personalDebtDomain);
	}

	@Override
	public PersonalDebtDTO getById(Integer id) {
		final PersonalDebtDomain domain = personalDebtDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	public PersonalDebtResult getAll(Pageable pageable) {
		final List<PersonalDebtDTO> personalDebts = new ArrayList<>();
		Page<PersonalDebtDomain> results = personalDebtDao.findAll(pageable);
		results.forEach(personalDebt -> personalDebts.add(convertDomainToDto(personalDebt)));
		
		final PersonalDebtResult personalDebtResult = new PersonalDebtResult();
		personalDebtResult.setList(personalDebts);
		return personalDebtResult;
	}

	@Override
	protected PersonalDebtDTO convertDomainToDto(PersonalDebtDomain domain) {
		final PersonalDebtDTO dto = new PersonalDebtDTO();
		dto.setId(domain.getId());
		dto.setAmount(domain.getAmount());
		dto.setDescription(domain.getDescription());
		return dto;
	}

	@Override
	protected PersonalDebtDomain convertDtoToDomain(PersonalDebtDTO dto) {
		final PersonalDebtDomain domain = new PersonalDebtDomain();
		domain.setId(dto.getId());
		domain.setAmount(dto.getAmount());
		domain.setDescription(dto.getDescription());
		return domain;
	}
	
}
