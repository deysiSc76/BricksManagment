package com.fiuni.sd.bricks_management.service.person;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.bricks_management.dto.PersonDTO;
import com.fiuni.sd.bricks_management.dto.PersonResult;
import com.fiuni.sd.bricks_management.service.base.BaseServiceImpl;
import com.fiuni.sd.bricks_management.dao.IPersonDAO;
import com.fiuni.sd.bricks_management.domain.PersonDomain;

@Service
public class PersonServiceImpl extends BaseServiceImpl<PersonDTO, PersonDomain, PersonResult> 
	implements IPersonService {

	@Autowired
	private IPersonDAO personDao;
	
	@Override
	@Transactional
	public PersonDTO save(PersonDTO dto) {
		final PersonDomain domain = convertDtoToDomain(dto);
		final PersonDomain personDomain = personDao.save(domain);
		return convertDomainToDto(personDomain);
	}

	@Override
	public PersonDTO getById(Integer id) {
		final PersonDomain domain = personDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	public PersonResult getAll(Pageable pageable) {
		final List<PersonDTO> people = new ArrayList<>();
		final PersonResult personResult = new PersonResult();
		personResult.setPeople(people);
		return personResult;
	}
	
	@Override
	protected PersonDTO convertDomainToDto(PersonDomain domain) {
		final PersonDTO dto = new PersonDTO();
		dto.setId(domain.getId());
		dto.setAddress(domain.getAddress());
		dto.setComentario(domain.getComment());
		dto.setEmail(domain.getEmail());
		dto.setName(domain.getName());
		dto.setNumber(domain.getNumber());
		return dto;
	}

	@Override
	protected PersonDomain convertDtoToDomain(PersonDTO dto) {
		final PersonDomain domain = new PersonDomain();
		domain.setId(dto.getId());
		domain.setAddress(dto.getAddress());
		domain.setComment(dto.getComentario());
		domain.setEmail(dto.getEmail());
		domain.setName(dto.getName());
		domain.setNumber(dto.getNumber());
		return domain;
	}
	
}
