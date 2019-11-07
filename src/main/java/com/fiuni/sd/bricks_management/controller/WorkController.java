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

import com.fiuni.sd.bricks_management.dto.work.WorkDTO;
import com.fiuni.sd.bricks_management.dto.work.WorkResult;
import com.fiuni.sd.bricks_management.service.work.IWorkService;
import com.fiuni.sd.bricks_management.utils.Setting;

@RestController
@RequestMapping("/works")
public class WorkController {
	
	@Autowired
	private IWorkService workService;
	
	@GetMapping("/{id}")
	public WorkDTO getById(@PathVariable(value = "id") Integer workId) {
		return workService.getById(workId);
	}
	
	@GetMapping(path = "/page/{page_num}")
	public WorkResult getWorks(@PathVariable(value = "page_num") Integer pageNum) {
		return workService.getAll(PageRequest.of(pageNum, Setting.PAGE_SIZE));
	}
	
	@GetMapping(path = "/page/{page_num}/search")
	public WorkResult searchWorks(@PathVariable(value = "page_num") Integer pageNum,
								  @RequestParam(value = "name") String name) {
	
		if (name != null) {
			return workService.getByName(name, PageRequest.of(pageNum, Setting.PAGE_SIZE));
		}
		return workService.getAll(PageRequest.of(pageNum, Setting.PAGE_SIZE));
	}

	@PutMapping("/{id}")
	public WorkDTO update(@PathVariable(value = "id") Integer id, @Valid @RequestBody WorkDTO work) {
		return workService.update(id, work);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void destroy(@PathVariable(value = "id") Integer workId) {
		 workService.delete(workId);
	}
	
	@PostMapping
	public WorkDTO save(@Valid @RequestBody WorkDTO work) {
		return workService.save(work);
	}

}
