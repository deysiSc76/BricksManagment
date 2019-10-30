package com.fiuni.sd.bricks_management.dao.work;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.fiuni.sd.bricks_management.domain.work.WorkDomain;

@XmlRootElement(name = "workResult")
public interface IWorkDao extends  CrudRepository<WorkDomain, Integer> {
	public Page<WorkDomain> findAll(Pageable pageable);

}
