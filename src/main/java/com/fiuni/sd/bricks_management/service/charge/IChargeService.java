package com.fiuni.sd.bricks_management.service.charge;

import org.springframework.stereotype.Service;

import com.fiuni.sd.bricks_management.dto.charge.ChargeDTO;
import com.fiuni.sd.bricks_management.dto.charge.ChargeResult;
import com.fiuni.sd.bricks_management.service.base.IBaseService;

@Service
public interface IChargeService extends IBaseService<ChargeDTO, ChargeResult>{
	
}