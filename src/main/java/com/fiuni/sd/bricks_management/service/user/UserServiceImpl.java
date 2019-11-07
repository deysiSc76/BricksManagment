package com.fiuni.sd.bricks_management.service.user;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.bricks_management.dao.users.IUserDAO;
import com.fiuni.sd.bricks_management.dao.work.IWorkDAO;
import com.fiuni.sd.bricks_management.domain.role.RoleDomain;
import com.fiuni.sd.bricks_management.domain.user.UserDomain;
import com.fiuni.sd.bricks_management.domain.work.WorkDomain;
import com.fiuni.sd.bricks_management.dto.rol.RolDTO;
import com.fiuni.sd.bricks_management.dto.user.UserDTO;
import com.fiuni.sd.bricks_management.dto.user.UserResult;
import com.fiuni.sd.bricks_management.service.base.BaseServiceImpl;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserDTO, UserDomain, UserResult> 
	implements IUserService {

	@Autowired
	private IUserDAO userDao;
	@Autowired
	private IWorkDAO workDao;
	
	@Override
	@Transactional
	public UserDTO save(UserDTO dto) {
		final UserDomain domain = convertDtoToDomain(dto);
		final UserDomain userDomain = userDao.save(domain);
		return convertDomainToDto(userDomain);
	}

	@Override
	@Transactional
	public UserDTO getById(Integer id) {
		final UserDomain domain = userDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	@Transactional
	public UserResult getAll(Pageable pageable) {
		final List<UserDTO> users = new ArrayList<>();
		Page<UserDomain> results = userDao.findAll(pageable);
		results.forEach(user -> users.add(convertDomainToDto(user)));
		
		final UserResult userResult = new UserResult();
		userResult.setUsers(users);
		return userResult;
	}
	
	@Override
	@Transactional
	public UserResult getByName(String name, Pageable pageable) {
		final List<UserDTO> users = new ArrayList<>();
		Page<UserDomain> results = userDao.findByName(name, pageable);
		results.forEach(user -> users.add(convertDomainToDto(user)));
		
		final UserResult userResult = new UserResult();
		userResult.setUsers(users);
		
		return userResult;
	}
	
	@Override
	@Transactional
	public UserResult getByLastName(String lastName, Pageable pageable) {
		final List<UserDTO> users = new ArrayList<>();
		Page<UserDomain> results = userDao.findByLastName(lastName, pageable);
		results.forEach(user -> users.add(convertDomainToDto(user)));
		
		final UserResult userResult = new UserResult();
		userResult.setUsers(users);
		
		return userResult;
	}
	
	@Override
	@Transactional
	public UserResult getByNameAndLastName(String name, String lastName, Pageable pageable) {
		final List<UserDTO> users = new ArrayList<>();
		Page<UserDomain> results = userDao.findByNameAndLastName(name, lastName, pageable);
		results.forEach(user -> users.add(convertDomainToDto(user)));
		
		final UserResult userResult = new UserResult();
		userResult.setUsers(users);
		return userResult;
	}
	
	public void delete(Integer id) {
		userDao.deleteById(id);
	}
	
	@Override
	protected UserDTO convertDomainToDto(UserDomain domain) {
		final UserDTO dto = new UserDTO();
		
		dto.setId(domain.getId());
		dto.setAddress(domain.getAddress());
		dto.setComentario(domain.getComment());
		dto.setDocument(domain.getDocument());
		dto.setEmail(domain.getEmail());
		dto.setName(domain.getName());
		dto.setLastName(domain.getLastName());
		dto.setNumber(domain.getNumber());
		dto.setPassword(domain.getPassword());
		dto.setRoles(convertToRolDtoList(domain.getRoles()));
		
		List<Integer> workIds = new ArrayList<>();
		List<WorkDomain> works = domain.getUserWorks();
		works.forEach(work -> workIds.add(work.getId()));
		dto.setWorksId(workIds);
		
		return dto;
	}

	@Override
	protected UserDomain convertDtoToDomain(UserDTO dto) {
		final UserDomain domain = new UserDomain();
		domain.setId(dto.getId());
		domain.setAddress(dto.getAddress());
		domain.setComment(dto.getComentario());
		domain.setDocument(dto.getDocument());
		domain.setEmail(dto.getEmail());
		domain.setLastName(dto.getLastName());
		domain.setName(dto.getName());
		domain.setNumber(dto.getNumber());
		domain.setPassword(dto.getPassword());
		domain.setRoles(convertToRolDomainList(dto.getRoles()));
		
		List<WorkDomain> works = new ArrayList<>();
		List<Integer> workIds = dto.getWorksId();
		workIds.forEach(id -> works.add(workDao.findById(id).get()));
		domain.setUserWorks(works);
		
		return domain;
	}

	@Override
	@Transactional
	public UserDTO update(Integer id, UserDTO user) {
		UserDomain toUpdate = userDao.findById(id).get();
		UserDomain newUser = convertDtoToDomain(user);
		
		toUpdate.setAddress(newUser.getAddress());
		toUpdate.setComment(newUser.getComment());
		toUpdate.setDocument(newUser.getDocument());
		toUpdate.setEmail(newUser.getEmail());
		toUpdate.setLastName(newUser.getLastName());
		toUpdate.setName(newUser.getName());
		toUpdate.setNumber(newUser.getNumber());
		toUpdate.setPassword(newUser.getPassword());
		toUpdate.setPersonalDebt(newUser.getPersonalDebt());
		toUpdate.setRoles(newUser.getRoles());
		
		return convertDomainToDto(userDao.save(toUpdate));
	}

	private RolDTO convertToRoleDto(RoleDomain domain) {
		final RolDTO dto = new RolDTO();
		dto.setId(domain.getId());
		dto.setType(domain.getType());
		
		return dto;
	}
	
	private RoleDomain convertToRolDomain(RolDTO dto) {
		final RoleDomain domain = new RoleDomain();
		domain.setId(dto.getId());
		domain.setType(dto.getType());
		
		return domain;
	}
	
	private List<RolDTO> convertToRolDtoList(List<RoleDomain> domains) {
		final List<RolDTO> dtos = new ArrayList<>();
		domains.forEach(domain -> dtos.add(convertToRoleDto(domain)));
		
		return dtos;
	}
	
	private List<RoleDomain> convertToRolDomainList(List<RolDTO> dtos) {
		final List<RoleDomain> domains = new ArrayList<>();
		dtos.forEach(dto -> domains.add(convertToRolDomain(dto)));
		
		return domains;
	}
}
