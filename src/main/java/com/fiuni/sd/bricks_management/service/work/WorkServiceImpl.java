package com.fiuni.sd.bricks_management.service.work;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.bricks_management.dao.users.IUserDAO;
import com.fiuni.sd.bricks_management.dao.work.IWorkDAO;
import com.fiuni.sd.bricks_management.domain.work.WorkDomain;
import com.fiuni.sd.bricks_management.dto.work.WorkDTO;
import com.fiuni.sd.bricks_management.dto.work.WorkResult;
import com.fiuni.sd.bricks_management.service.base.BaseServiceImpl;
@Service
public class WorkServiceImpl extends BaseServiceImpl<WorkDTO, WorkDomain, WorkResult> implements IWorkService{
	@Autowired
	private IWorkDAO workDao;
	@Autowired
	private IUserDAO clientDao;
	@Override
	@Transactional
	public WorkDTO save(WorkDTO dto) {
		final WorkDomain workDomain = convertDtoToDomain(dto);
		final WorkDomain work = workDao.save(workDomain);
		return convertDomainToDto(work);
	}

	@Override
	@Transactional
	public WorkDTO getById(Integer id) {
		final WorkDomain workDomain = workDao.findById(id).orElse(null);
		return workDomain == null ? null :  convertDomainToDto(workDomain);
	}

	@Override
	@Transactional
	public WorkResult getAll(Pageable pageable) {
		final List<WorkDTO> works = new ArrayList<>();
		Page<WorkDomain> results= workDao.findAll(pageable);
		results.forEach(work->works.add(convertDomainToDto(work)));

		final WorkResult workResult = new WorkResult();
		workResult.setList(works);
		return workResult;
	}

	protected WorkDTO convertDomainToDto(WorkDomain domain) {
		final WorkDTO work = new WorkDTO();
		work.setId(domain.getId());
		work.setName(domain.getName());
		work.setAddress(domain.getAddress());
		work.setDescription(domain.getDescription());
		work.setClientId(domain.getClient().getId());
		work.setPersonnelManager(domain.getPersonManager());
		work.setStartDate(domain.getStartDate());
		work.setEnd_date(domain.getEndDate());
		return work;
	}
	protected WorkDomain convertDtoToDomain(WorkDTO dto) {
		final WorkDomain work = new WorkDomain();
		work.setId(dto.getId());
		work.setName(dto.getName());
		work.setAddress(dto.getAddress());
		work.setDescription(dto.getDescription());
		work.setClient(clientDao.findById(dto.getClientId()).get());
		work.setPersonManager(dto.getPersonnelManager());
		work.setStartDate(dto.getStartDate());
		work.setEndDate(dto.getEnd_date());
		return work;
	}

	@Override
	public void delete(Integer workId) {
		workDao.deleteById(workId);

	}
	@Override
	public WorkDTO update(Integer id, WorkDTO work) {
		WorkDomain toUpdate = workDao.findById(id).get();
		WorkDomain newWork = convertDtoToDomain(work);
		toUpdate.setAddress(newWork.getAddress());
		toUpdate.setName(newWork.getName());
		toUpdate.setBudget(newWork.getBudget());
		toUpdate.setDescription(newWork.getDescription());
		toUpdate.setClient(newWork.getClient());
		toUpdate.setPersonManager(newWork.getPersonManager());
		toUpdate.setStartDate(newWork.getStartDate());
		toUpdate.setEndDate(newWork.getEndDate());

		workDao.save(toUpdate);

		return convertDomainToDto(toUpdate);
	}

	@Override
	public WorkResult getByName(String name, Pageable pageable) {
		final List<WorkDTO> works = new ArrayList<>();
		Page<WorkDomain> results = workDao.findByName(name, pageable);
		results.forEach(work -> works.add(convertDomainToDto(work)));

		final WorkResult workResult = new WorkResult();
		workResult.setWorks(works);

		return workResult;
	}




}
