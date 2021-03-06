package com.fiuni.sd.bricks_management.service.personal_debt;

import org.springframework.data.domain.Pageable;

import com.fiuni.sd.bricks_management.dto.personalDebt.PersonalDebtDTO;
import com.fiuni.sd.bricks_management.dto.personalDebt.PersonalDebtResult;
import com.fiuni.sd.bricks_management.service.base.IBaseService;

public interface IPersonalDebtService extends IBaseService<PersonalDebtDTO, PersonalDebtResult> {
	
	public void delete(Integer id);
	
	public PersonalDebtDTO update(Integer id, PersonalDebtDTO personalDebt);
	
	public PersonalDebtResult getByDescription(String description, Pageable pageable);
	
}
