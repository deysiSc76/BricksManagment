package com.fiuni.sd.bricks_management.service.budget;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.bricks_management.dao.budget.IBudgetDAO;
import com.fiuni.sd.bricks_management.dao.budgetConcept.IBudgetConceptDAO;
import com.fiuni.sd.bricks_management.dao.budgetDetail.IBudgetDetailDAO;
import com.fiuni.sd.bricks_management.dao.work.IWorkDAO;
import com.fiuni.sd.bricks_management.domain.budget.BudgetDomain;
import com.fiuni.sd.bricks_management.domain.budgetDetail.BudgetDetailDomain;
import com.fiuni.sd.bricks_management.domain.charge.ChargeDomain;
import com.fiuni.sd.bricks_management.dto.budget.BudgetDTO;
import com.fiuni.sd.bricks_management.dto.budget.BudgetResult;
import com.fiuni.sd.bricks_management.service.base.BaseServiceImpl;
import com.fiuni.sd.bricks_management.service.charge.ChargeServiceImpl;
import com.fiuni.sd.bricks_management.dto.budgetDetail.BudgetDetailDTO;
import com.fiuni.sd.bricks_management.dto.charge.ChargeDTO;

@Service
public class BudgetServiceImpl extends BaseServiceImpl<BudgetDTO,BudgetDomain,BudgetResult>{
	
	@Autowired
	private IBudgetDAO budgetDao;
	@Autowired
	private IWorkDAO workDao;	
	@Autowired
	private IBudgetConceptDAO budgetConceptDao;
	@Autowired
	private ChargeServiceImpl chargeService;
	
	@Override
	@Transactional
	public BudgetDTO save(BudgetDTO dto) {
		BudgetDomain budgetDomain = convertDtoToDomain(dto);
		return convertDomainToDto(budgetDao.save(budgetDomain));
	}

	@Override
	public BudgetDTO getById(Integer id) {
		return convertDomainToDto( budgetDao.findById(id).get() );
	}

	@Override
	public BudgetResult getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected BudgetDTO convertDomainToDto(BudgetDomain domain) {
		BudgetDTO dto = new BudgetDTO();
		dto.setId(domain.getId());
		dto.setTotalAmount(domain.getTotalAmount());
		dto.setWorkId(domain.getWork().getId());
		dto.setDetailDtos(convertToDetailDtoList(domain.getBudgetDetails()));
		dto.setChargeDtos(chargeService.convertToDtoList(domain.getCharges()));
		return dto;
	}

	@Override
	protected BudgetDomain convertDtoToDomain(BudgetDTO dto) {
		BudgetDomain domain = new BudgetDomain();
		domain.setId(dto.getId());
		domain.setTotalAmount(dto.getTotalAmount());
		domain.setWork(workDao.findById(dto.getWorkId()).get());
		domain.setBudgetDetails(convertToDetailDomainList(dto.getDetailDtos()));
		domain.setCharges(chargeService.convertToDomainList(dto.getChargeDtos()));
		return domain;
	}
	
	private BudgetDetailDomain convertToDetailDomain(BudgetDetailDTO dto) {
		BudgetDetailDomain domain = new BudgetDetailDomain();
		domain.setId(dto.getId());
		domain.setAmount(dto.getAmount());
		domain.setBudget(budgetDao.findById(dto.getBudgetId()).get());
		domain.setBudgetConcept(budgetConceptDao.findById(dto.getBudgetConceptId()).get());
		domain.setQuantity(dto.getQuantity());
		return domain;
	}
	
	private BudgetDetailDTO convertToDetailDto(BudgetDetailDomain domain) {
		BudgetDetailDTO dto = new BudgetDetailDTO();
		dto.setId(domain.getId());
		dto.setAmount(domain.getAmount());
		dto.setQuantity(domain.getQuantity());
		dto.setBudgetConceptId(domain.getBudgetConcept().getId());
		dto.setBudgetId(domain.getBudget().getId());
		return dto;
	}
	
	private List<BudgetDetailDomain> convertToDetailDomainList(List<BudgetDetailDTO> list){
		ArrayList<BudgetDetailDomain> domains = new ArrayList<>();
		for( BudgetDetailDTO dto : list ) {
			domains.add(convertToDetailDomain(dto));
		}
		return domains;
	}
	
	private List<BudgetDetailDTO> convertToDetailDtoList(List<BudgetDetailDomain> list){
		ArrayList<BudgetDetailDTO> dtos = new ArrayList<>();
		for( BudgetDetailDomain domain : list ) {
			dtos.add(convertToDetailDto( domain ));
		}
		return dtos;
	}
}
