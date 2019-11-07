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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiuni.sd.bricks_management.dto.user.UserDTO;
import com.fiuni.sd.bricks_management.dto.user.UserResult;
import com.fiuni.sd.bricks_management.service.user.IUserService;
import com.fiuni.sd.bricks_management.utils.Setting;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@GetMapping("/{id}")
	public UserDTO getById(@PathVariable(value = "id") Integer userId) {
		return userService.getById(userId);
	}
	
	@GetMapping(path = "/page/{page_num}/search")
	public UserResult searchUsers(@PathVariable(value = "page_num") Integer pageNum,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "document", required = false) String document) {
		
		if (name != null) {
			if (lastName == null) {
				return userService.getByName(name, PageRequest.of(pageNum, Setting.PAGE_SIZE));
			}
			else if (lastName != null) {
				return userService.getByNameAndLastName(name, lastName, PageRequest.of(pageNum, Setting.PAGE_SIZE));
			}
		}
		else if (name == null) {
			if (lastName != null) {
				return userService.getByLastName(lastName, PageRequest.of(pageNum, Setting.PAGE_SIZE));
			}
		}
		return userService.getAll(PageRequest.of(pageNum, Setting.PAGE_SIZE));
	}
	
	@GetMapping(path = "/page/{page_num}")
	public UserResult getUsers(@PathVariable(value = "page_num") Integer pageNum) {
		return userService.getAll(PageRequest.of(pageNum, Setting.PAGE_SIZE));
	}

	@PutMapping("/{id}")
	public UserDTO update(@PathVariable(value = "id") Integer id, @Valid @RequestBody UserDTO user) {
		return userService.update(id, user);
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
