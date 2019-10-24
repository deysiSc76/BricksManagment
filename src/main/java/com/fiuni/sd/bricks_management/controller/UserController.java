package com.fiuni.sd.bricks_management.controller;

import javax.validation.Valid; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fiuni.sd.bricks_management.dto.user.UserDTO;
import com.fiuni.sd.bricks_management.dto.user.UserResult;
import com.fiuni.sd.bricks_management.service.user.IUserService;
import com.fiuni.sd.bricks_management.utils.Setting;

@RestController
@RequestMapping(value = "/user", method = RequestMethod.GET, produces = {"application/xml", "application/json"})
public class UserController {

	@Autowired
	private IUserService userService;
	
	//@GetMapping("/{id}")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/xml", "application/json" })
    @ResponseBody
	public UserDTO getById(@PathVariable(value = "id") Integer userId) {
		return userService.getById(userId);
	}
	
	@GetMapping(path = "/page/", params = {"page", "size"})
	public UserResult getUsers(@PathVariable(value = "page_num") Integer pageNum) {
		return userService.getAll(PageRequest.of(pageNum, Setting.PAGE_SIZE));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = { "application/xml", "application/json" })
    @ResponseBody
	public UserDTO update(@PathVariable(value = "id") Integer userId, @Valid @RequestBody UserDTO user) {
		user.setId(userId);
		return userService.save(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void destroy(@PathVariable(value = "id") Integer userId) {
		 userService.delete(userId);
	}
	
	@PostMapping
	public UserDTO save(@Valid @RequestBody UserDTO user) {
		return userService.save(user);
	}
	
}
