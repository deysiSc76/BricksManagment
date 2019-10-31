package com.fiuni.sd.bricks_management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public ResponseEntity<ProviderDTO> getById(@PathVariable(value = "id") Integer providerId) {
		ProviderDTO provider = providerService.getById(providerId);
		if(provider == null) 
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<>(provider, HttpStatus.OK);
	}
	
	@GetMapping(path = "/page/{page_num}")
	public ProviderResult getProviders(@PathVariable(value = "page_num")Integer pageNum) {
		return providerService.getAll(PageRequest.of(pageNum, Setting.PAGE_SIZE));
	}
	
	@PostMapping()
	public ResponseEntity<ProviderDTO> save(@Valid @RequestBody ProviderDTO provider) {
		return new ResponseEntity<>(providerService.save(provider), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ProviderDTO> destroy(@PathVariable(value = "id") Integer providerId) {
		 providerService.delete(providerId);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = { "application/xml", "application/json" })
    @ResponseBody
	public ProviderDTO update(@PathVariable(value = "id") Integer providerId, @Valid @RequestBody ProviderDTO provider) {
		provider.setId(providerId);
		return providerService.save(provider);
	}

}
