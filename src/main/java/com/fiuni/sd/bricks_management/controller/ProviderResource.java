package com.fiuni.sd.bricks_management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiuni.sd.bricks_management.dto.provider.ProviderDTO;
import com.fiuni.sd.bricks_management.dto.provider.ProviderResult;
import com.fiuni.sd.bricks_management.service.provider.IProviderService;
import com.fiuni.sd.bricks_management.utils.Setting;

@RestController
@RequestMapping("/providers")
public class ProviderResource {
	@Autowired
	private IProviderService providerService;
	
	@GetMapping("/{id}")
	public ProviderDTO getById(@PathVariable(value = "id") Integer providerId) {
		return providerService.getById(providerId);
	}
	@GetMapping(path = "/page/{page_num}")
	public ProviderResult getProviders(@PathVariable(value = "page_num")Integer pageNum) {
		return providerService.getAll(PageRequest.of(pageNum, Setting.PAGE_SIZE));
	}
	@PostMapping()
	public ProviderDTO save(@Valid @RequestBody ProviderDTO client) {
		return providerService.save(client);
	}

}
