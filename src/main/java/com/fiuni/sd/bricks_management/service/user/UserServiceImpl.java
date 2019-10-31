package com.fiuni.sd.bricks_management.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.bricks_management.dao.role.IRoleDAO;
import com.fiuni.sd.bricks_management.dao.users.IUserDAO;
import com.fiuni.sd.bricks_management.domain.role.RoleDomain;
import com.fiuni.sd.bricks_management.domain.user.UserDomain;
import com.fiuni.sd.bricks_management.dto.user.UserDTO;
import com.fiuni.sd.bricks_management.dto.user.UserResult;
import com.fiuni.sd.bricks_management.service.base.BaseServiceImpl;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserDTO, UserDomain, UserResult> 
	implements IUserService {

	@Autowired
	private IUserDAO userDao;
	@Autowired
	private IRoleDAO roleDao;
	
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
		
		final List<Integer> roles_id = new ArrayList<>();
		final List<RoleDomain> user_roles = domain.getRoles();
		user_roles.forEach(user_role -> roles_id.add(user_role.getId()));
		dto.setRoles(roles_id);
		
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
		
		final List<RoleDomain> roles = new ArrayList<>();
		final List<Integer> roles_id = dto.getRoles();
		roles_id.forEach(id -> roles.add(roleDao.findById(id).get()));
		domain.setRoles(roles);
		
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

}
