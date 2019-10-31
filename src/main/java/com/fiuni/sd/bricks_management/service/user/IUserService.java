package com.fiuni.sd.bricks_management.service.user;

import com.fiuni.sd.bricks_management.dto.user.UserDTO;
import com.fiuni.sd.bricks_management.dto.user.UserResult;
import com.fiuni.sd.bricks_management.service.base.IBaseService;

public interface IUserService extends IBaseService<UserDTO, UserResult> {
	
	public void delete(Integer id);
	
	public UserDTO update(Integer id, UserDTO user);
	
}
