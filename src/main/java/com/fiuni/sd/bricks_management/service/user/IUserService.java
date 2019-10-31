package com.fiuni.sd.bricks_management.service.user;

import org.springframework.data.domain.Pageable;

import com.fiuni.sd.bricks_management.dto.user.UserDTO;
import com.fiuni.sd.bricks_management.dto.user.UserResult;
import com.fiuni.sd.bricks_management.service.base.IBaseService;

public interface IUserService extends IBaseService<UserDTO, UserResult> {

	public void delete(Integer id);

	public UserDTO update(Integer id, UserDTO user);

	public UserResult getByName(String name, Pageable pageable);

	public UserResult getByLastName(String lastName, Pageable pageable);

	public UserResult getByNameAndLastName(String name, String lastName, Pageable pageable);

}
