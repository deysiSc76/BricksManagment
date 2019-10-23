package com.fiuni.sd.bricks_management.controller;

import javax.validation.Valid; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fiuni.sd.bricks_management.dto.PersonDTO;
import com.fiuni.sd.bricks_management.dto.PersonResult;
import com.fiuni.sd.bricks_management.service.person.IPersonService;
import com.fiuni.sd.bricks_management.utils.Setting;

@RestController
@RequestMapping(value = "/people", method = RequestMethod.GET, produces = {"application/xml", "application/json"})
public class PersonController {

	@Autowired
	private IPersonService personService;
	
	//@GetMapping("/{id}")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/xml", "application/json" })
    @ResponseBody
	public PersonDTO getById(@PathVariable(value = "id") Integer personId) {
		return personService.getById(personId);
	}
	
	@GetMapping(path = "/page/", params = {"page", "size"})
	public PersonResult getPeople(@PathVariable(value = "page_num") Integer pageNum) {
		return personService.getAll(PageRequest.of(pageNum, Setting.PAGE_SIZE));
	}
	
	@PostMapping
	public PersonDTO save(@Valid @RequestBody PersonDTO person) {
		return personService.save(person);
	}
	
}
