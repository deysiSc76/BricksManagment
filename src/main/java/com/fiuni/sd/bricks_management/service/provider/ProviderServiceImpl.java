package com.fiuni.sd.bricks_management.service.provider;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiuni.sd.bricks_management.dao.providers.IProviderDao;
import com.fiuni.sd.bricks_management.domain.provider.ProviderDomain;
import com.fiuni.sd.bricks_management.dto.provider.ProviderDTO;
import com.fiuni.sd.bricks_management.dto.provider.ProviderResult;
import com.fiuni.sd.bricks_management.service.base.BaseServiceImpl;

@Service
public class ProviderServiceImpl extends BaseServiceImpl<ProviderDTO, ProviderDomain, ProviderResult> implements IProviderService {

	@Autowired
	private IProviderDao providerDao;

	@Override
	@Transactional
	public ProviderDTO save(ProviderDTO dto) {
		final ProviderDomain providerDomain = convertDtoToDomain(dto);
		final ProviderDomain provider = providerDao.save(providerDomain);
		return convertDomainToDto(provider);
	}

	@Override
	@Transactional
	public ProviderDTO getById(Integer id) {
		final ProviderDomain providerDomain = providerDao.findById(id).orElse(null);
		return providerDomain == null ? null :  convertDomainToDto(providerDomain);
	}


	@Override
	@Transactional
	public ProviderResult getAll(Pageable pageable) {
		final List<ProviderDTO> providers = new ArrayList<>();
		Page<ProviderDomain> results=providerDao.findAll(pageable);
		results.forEach(provider -> providers.add(convertDomainToDto(provider)));

		final ProviderResult providerResult = new ProviderResult();
		providerResult.setList(providers);
		return providerResult;
	}

	@Override
	@Transactional
	public ProviderResult getByBussinessName(String bussinessName, Pageable pageable) {
		final List<ProviderDTO> providers = new ArrayList<>();
		Page<ProviderDomain> results=providerDao.findByBussinessName(bussinessName, pageable);
		results.forEach(provider -> providers.add(convertDomainToDto(provider)));

		final ProviderResult providerResult = new ProviderResult();
		providerResult.setList(providers);
		return providerResult;
	}

	@Override
	@Transactional
	public ProviderResult getByRuc(String ruc, Pageable pageable) {
		final List<ProviderDTO> providers = new ArrayList<>();
		Page<ProviderDomain> results=providerDao.findByRuc(ruc, pageable);
		results.forEach(provider -> providers.add(convertDomainToDto(provider)));

		final ProviderResult providerResult = new ProviderResult();
		providerResult.setList(providers);
		return providerResult;
	}

	@Override
	@Transactional
	public ProviderResult getByBussinessNameAndRuc(String bussinessName, String ruc, Pageable pageable) {
		final List<ProviderDTO> providers = new ArrayList<>();
		Page<ProviderDomain> results=providerDao.findByBussinessNameAndRuc(bussinessName, ruc, pageable);
		results.forEach(provider->providers.add(convertDomainToDto(provider)));

		final ProviderResult providerResult = new ProviderResult();
		providerResult.setList(providers);
		return providerResult;
	}

	@Override
	protected ProviderDTO convertDomainToDto(ProviderDomain domain) {
		final ProviderDTO provider = new ProviderDTO();
		provider.setId(domain.getId());
		provider.setBusinessName(domain.getBussinessName());
		provider.setNumber(domain.getNumber());
		provider.setAddress(domain.getAddress());
		provider.setRuc(domain.getRuc());
		return provider;
	}

	@Override
	protected ProviderDomain convertDtoToDomain(ProviderDTO dto) {
		final ProviderDomain provider = new ProviderDomain();
		provider.setId(dto.getId());
		provider.setBussinessName(dto.getBusinessName());
		provider.setNumber(dto.getNumber());
		provider.setAddress(dto.getAddress());
		provider.setRuc(dto.getRuc());
		return provider;
	}

	@Override
	public void delete(Integer providerId) {
		providerDao.deleteById(providerId);
	}

}
