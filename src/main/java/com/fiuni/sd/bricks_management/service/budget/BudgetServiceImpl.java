package com.fiuni.sd.bricks_management.service.budget;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.bricks_management.dao.budget.IBudgetDAO;
import com.fiuni.sd.bricks_management.dao.budgetConcept.IBudgetConceptDAO;
import com.fiuni.sd.bricks_management.dao.work.IWorkDAO;
import com.fiuni.sd.bricks_management.domain.budget.BudgetDomain;
import com.fiuni.sd.bricks_management.domain.budgetDetail.BudgetDetailDomain;
import com.fiuni.sd.bricks_management.dto.budget.BudgetDTO;
import com.fiuni.sd.bricks_management.dto.budget.BudgetResult;
import com.fiuni.sd.bricks_management.dto.budgetDetail.BudgetDetailDTO;
import com.fiuni.sd.bricks_management.service.base.BaseServiceImpl;
import com.fiuni.sd.bricks_management.service.charge.ChargeServiceImpl;


@Service
public class BudgetServiceImpl extends BaseServiceImpl<BudgetDTO,BudgetDomain,BudgetResult>
	implements IBudgetService{

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
		final BudgetDomain budgetDomain = convertDtoToDomain(dto);
		return convertDomainToDto(budgetDao.save(budgetDomain));
	}


	@Override
	@Transactional
	public BudgetDTO update(BudgetDTO dto, Integer budgetId) {
		final BudgetDTO toUpdate = convertDomainToDto(budgetDao.findById(budgetId).get());
		toUpdate.setTotalAmount(dto.getTotalAmount());
		toUpdate.setWorkId(dto.getWorkId());
		toUpdate.setDetailDtos(dto.getDetailDtos());
		toUpdate.setChargeDtos(dto.getChargeDtos());
		return save(toUpdate);
	}

	@Override
	@Transactional
	public BudgetDTO getById(Integer id) {
		return convertDomainToDto( budgetDao.findById(id).get() );
	}

	@Override
	@Transactional
	public BudgetResult getAll(Pageable pageable) {
		final List<BudgetDTO> dtos = new ArrayList<>();
		Page<BudgetDomain> resultDomains = budgetDao.findAll(pageable);
		resultDomains.forEach(domain -> dtos.add(convertDomainToDto(domain)));
		final BudgetResult budgetResult = new BudgetResult();
		budgetResult.setBudgets(dtos);
		return budgetResult;
	}


	@Override
	protected BudgetDTO convertDomainToDto(BudgetDomain domain) {
		final BudgetDTO dto = new BudgetDTO();
		dto.setId(domain.getId());
		dto.setTotalAmount(domain.getTotalAmount());
		dto.setWorkId(domain.getWork().getId());
		dto.setDetailDtos(convertToDetailDtoList(domain.getBudgetDetails()));
		dto.setChargeDtos(chargeService.convertToDtoList(domain.getCharges()));
		return dto;
	}

	@Override
	protected BudgetDomain convertDtoToDomain(BudgetDTO dto) {
		final BudgetDomain domain = new BudgetDomain();
		domain.setId(dto.getId());
		domain.setTotalAmount(dto.getTotalAmount());
		domain.setWork(workDao.findById(dto.getWorkId()).get());
		domain.setBudgetDetails(convertToDetailDomainList(dto.getDetailDtos()));
		domain.setCharges(chargeService.convertToDomainList(dto.getChargeDtos()));
		return domain;
	}

	private BudgetDetailDomain convertToDetailDomain(BudgetDetailDTO dto) {
		final BudgetDetailDomain domain = new BudgetDetailDomain();
		domain.setId(dto.getId());
		domain.setAmount(dto.getAmount());
		domain.setBudget(budgetDao.findById(dto.getBudgetId()).get());
		domain.setBudgetConcept(budgetConceptDao.findById(dto.getBudgetConceptId()).get());
		domain.setQuantity(dto.getQuantity());
		return domain;
	}

	private BudgetDetailDTO convertToDetailDto(BudgetDetailDomain domain) {
		final BudgetDetailDTO dto = new BudgetDetailDTO();
		dto.setId(domain.getId());
		dto.setAmount(domain.getAmount());
		dto.setQuantity(domain.getQuantity());
		dto.setBudgetConceptId(domain.getBudgetConcept().getId());
		dto.setBudgetId(domain.getBudget().getId());
		return dto;
	}

	private List<BudgetDetailDomain> convertToDetailDomainList(List<BudgetDetailDTO> list){
		final ArrayList<BudgetDetailDomain> domains = new ArrayList<>();
		list.forEach( dto -> domains.add( convertToDetailDomain(dto) ) );
		return domains;
	}

	private List<BudgetDetailDTO> convertToDetailDtoList(List<BudgetDetailDomain> list){
		final ArrayList<BudgetDetailDTO> dtos = new ArrayList<>();
		list.forEach( domain -> dtos.add( convertToDetailDto( domain ) ) );
		return dtos;
	}
}
