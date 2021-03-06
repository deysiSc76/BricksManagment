package com.fiuni.sd.bricks_management.service.charge;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fiuni.sd.bricks_management.dto.charge.ChargeDTO;
import com.fiuni.sd.bricks_management.dto.charge.ChargeResult;
import com.fiuni.sd.bricks_management.service.base.IBaseService;

@Service
public interface IChargeService extends IBaseService<ChargeDTO, ChargeResult>{
	
	public ChargeDTO update(ChargeDTO dto, Integer id);
	
	public ChargeResult getByDate(String date, Pageable pageable);
}
