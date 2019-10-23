package com.fiuni.sd.bricks_management.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.bricks_management.dto.user.UserDTO;
import com.fiuni.sd.bricks_management.dto.user.UserResult;
import com.fiuni.sd.bricks_management.service.base.BaseServiceImpl;
import com.fiuni.sd.bricks_management.dao.users.IUserDAO;
import com.fiuni.sd.bricks_management.domain.user.UserDomain;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserDTO, UserDomain, UserResult> 
	implements IUserService {

	@Autowired
	private IUserDAO userDao;
	
	@Override
	@Transactional
	public UserDTO save(UserDTO dto) {
		final UserDomain domain = convertDtoToDomain(dto);
		final UserDomain userDomain = userDao.save(domain);
		return convertDomainToDto(userDomain);
	}

	@Override
	public UserDTO getById(Integer id) {
		final UserDomain domain = userDao.findById(id).get();
		return convertDomainToDto(domain);
	}

	@Override
	public UserResult getAll(Pageable pageable) {
		final List<UserDTO> users = new ArrayList<>();
		final UserResult userResult = new UserResult();
		userResult.setUsers(users);
		return userResult;
	}
	
	@Override
	protected UserDTO convertDomainToDto(UserDomain domain) {
		final UserDTO dto = new UserDTO();
		dto.setId(domain.getId());
		dto.setAddress(domain.getAddress());
		dto.setComentario(domain.getComment());
		dto.setEmail(domain.getEmail());
		dto.setName(domain.getName());
		dto.setNumber(domain.getNumber());
		return dto;
	}

	@Override
	protected UserDomain convertDtoToDomain(UserDTO dto) {
		final UserDomain domain = new UserDomain();
		domain.setId(dto.getId());
		domain.setAddress(dto.getAddress());
		domain.setComment(dto.getComentario());
		domain.setEmail(dto.getEmail());
		domain.setName(dto.getName());
		domain.setNumber(dto.getNumber());
		return domain;
	}
	
}
