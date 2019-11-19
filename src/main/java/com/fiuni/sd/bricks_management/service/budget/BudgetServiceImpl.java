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
import com.fiuni.sd.bricks_management.dao.budgetDetail.IBudgetDetailDAO;
import com.fiuni.sd.bricks_management.dao.work.IWorkDAO;
import com.fiuni.sd.bricks_management.domain.budget.BudgetDomain;
import com.fiuni.sd.bricks_management.domain.budgetDetail.BudgetDetailDomain;
import com.fiuni.sd.bricks_management.domain.payment.PaymentDomain;
import com.fiuni.sd.bricks_management.dto.budget.BudgetDTO;
import com.fiuni.sd.bricks_management.dto.budget.BudgetResult;
import com.fiuni.sd.bricks_management.dto.budget.FullBudgetDTO;
import com.fiuni.sd.bricks_management.dto.budgetDetail.BudgetDetailDTO;
import com.fiuni.sd.bricks_management.dto.payment.FullPaymentDTO;
import com.fiuni.sd.bricks_management.dto.payment.PaymentDTO;
import com.fiuni.sd.bricks_management.dto.paymentDetail.PaymentDetailDTO;
import com.fiuni.sd.bricks_management.service.base.BaseServiceImpl;
import com.fiuni.sd.bricks_management.service.budgetDetail.IBudgetDetailService;
import com.fiuni.sd.bricks_management.service.charge.ChargeServiceImpl;
import com.fiuni.sd.bricks_management.service.paymentDetail.IPaymentDetailService;

@Service
public class BudgetServiceImpl extends BaseServiceImpl<BudgetDTO,BudgetDomain,BudgetResult>
	implements IBudgetService{

	@Autowired
	private IBudgetDAO budgetDao;
	@Autowired
	private IBudgetDetailDAO budgetDetailDao;
	@Autowired
	private IBudgetDetailService budgetDetailService;
	@Autowired
	private IWorkDAO workDao;
	@Autowired
	private IBudgetConceptDAO budgetConceptDao;
	@Autowired
	private ChargeServiceImpl chargeService;
	
	@Override
	@Transactional
	public BudgetDTO save(BudgetDTO dto) {
		final BudgetDomain domain = convertDtoToDomain(dto);
		final BudgetDomain paymentDomain = budgetDao.save(domain);
		return convertDomainToDto(paymentDomain);
	}
	
	

	@Override
	@Transactional
	public FullBudgetDTO save(FullBudgetDTO fullBudget) {
		fullBudget.setBudget(save(fullBudget.getBudget()));
		fullBudget.getDetais().forEach(
				(BudgetDetailDTO det)->
					det.setBudgetId(fullBudget.getBudget().getId())
		);
		fullBudget.setDetails(
				budgetDetailService.saveList(fullBudget.getDetais()).getList())
		;
		return fullBudget;
	}
	@Override
	public FullBudgetDTO getFullBudget(Integer id) {
		final BudgetDomain domain = budgetDao.findById(id).get();
		return convertDomainToFullDto(domain);
	}
	protected FullBudgetDTO convertDomainToFullDto(BudgetDomain domain) {
		final BudgetDTO budgetDto = new BudgetDTO();
		budgetDto.setId(domain.getId());
		budgetDto.setWorkId(domain.getWork().getId());
		budgetDto.setTotalAmount(domain.getTotalAmount());

		FullBudgetDTO dto = new FullBudgetDTO();
		dto.setBudget(budgetDto);		
		dto.setDetails(
			budgetDetailService.getByBudgetId(domain.getId()).getList()
		);		
		
		return dto;
	}
	
	/*
	 * Método para actualizar un presupuesto
	 * Actualmente solo funciona para actualizar las cabeceras,
	 * todavía no es posible actualizar la cabecera y los detalles de una vez 
	 */

	@Override
	@Transactional
	public BudgetDTO update(BudgetDTO dto, Integer budgetId) {
		
		/* arrayList para guardar los ids de cada detalle del dto
		 * y asi tener un registro de los que ya se encuentran guardados
		 * para posteriormente sobreescribirlos
		*/
		List<Integer> detailIds = new ArrayList<>();
		
		final BudgetDTO toUpdate = convertDomainToDto(budgetDao.findById(budgetId).get());
		
		// se agregan al arrayList los ids de cada detalle de un budget que se encuentra guardado
		toUpdate.getDetails().forEach(detail -> detailIds.add(detail.getId()));
		
		toUpdate.setTotalAmount(dto.getTotalAmount());
		toUpdate.setWorkId(dto.getWorkId());
		// toUpdate.setDetails(updateDetails(dto.getDetails(), detailIds));
		
		return save(toUpdate);
	}
	
	public List<BudgetDetailDTO> updateDetails(List<BudgetDetailDTO> details, List<Integer> detailIds) {
		return null;
	}
	
	
	/*
	 * Método para actualizar un detalle específico dado su id
	 */
	@Override
	@Transactional
	public BudgetDetailDTO updateDetail(Integer id, BudgetDetailDTO detail) {
		final BudgetDetailDTO toUpdate = convertToDetailDto(budgetDetailDao.findById(id).get());
		toUpdate.setAmount(detail.getAmount());
		toUpdate.setBudgetConceptId(detail.getBudgetConceptId());
		toUpdate.setQuantity(detail.getQuantity());
		
		return toUpdate;
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
	public void delete(Integer id) {
		budgetDao.deleteById(id);
	}
	
	@Override
	public void deleteDetail(Integer id) {
		budgetDetailDao.deleteById(id);
	}

	@Override
	protected BudgetDTO convertDomainToDto(BudgetDomain domain) {
		final BudgetDTO dto = new BudgetDTO();
		dto.setId(domain.getId());
		dto.setTotalAmount(domain.getTotalAmount());
		dto.setWorkId(domain.getWork().getId());
		dto.setDetails(convertToDetailDtoList(domain.getBudgetDetails()));
	    dto.setCharges(chargeService.convertToDtoList(domain.getCharges()));

	    return dto;
	}

	@Override
	protected BudgetDomain convertDtoToDomain(BudgetDTO dto) {
		final BudgetDomain domain = new BudgetDomain();
		domain.setId(dto.getId());
		domain.setTotalAmount(dto.getTotalAmount());
		domain.setWork(workDao.findById(dto.getWorkId()).get());
		
		return domain;
	}

	public BudgetDetailDomain convertToDetailDomain(BudgetDetailDTO dto) {
		final BudgetDetailDomain domain = new BudgetDetailDomain();
		domain.setId(dto.getId());
		domain.setAmount(dto.getAmount());
		domain.setBudget(budgetDao.findById(dto.getBudgetId()).get());
		domain.setBudgetConcept(budgetConceptDao.findById(dto.getBudgetConceptId()).get());
		domain.setQuantity(dto.getQuantity());
		
		return domain;
	}

	public BudgetDetailDTO convertToDetailDto(BudgetDetailDomain domain) {
		final BudgetDetailDTO dto = new BudgetDetailDTO();
		dto.setId(domain.getId());
		dto.setAmount(domain.getAmount());
		dto.setQuantity(domain.getQuantity());
		dto.setBudgetConceptId(domain.getBudgetConcept().getId());
		dto.setBudgetId(domain.getBudget().getId());
		
		return dto;
	}

	public List<BudgetDetailDomain> convertToDetailDomainList(List<BudgetDetailDTO> list){
		final ArrayList<BudgetDetailDomain> domains = new ArrayList<>();
		list.forEach( dto -> domains.add( convertToDetailDomain(dto) ) );
		
		return domains;
	}

	public List<BudgetDetailDTO> convertToDetailDtoList(List<BudgetDetailDomain> list){
		final ArrayList<BudgetDetailDTO> dtos = new ArrayList<>();
		list.forEach( domain -> dtos.add( convertToDetailDto( domain ) ) );
		
		return dtos;
	}


	
}
