package com.fiuni.sd.bricks_management.dao.work;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.bricks_management.domain.work.WorkDomain;

@Repository
public interface IWorkDAO extends CrudRepository<WorkDomain,Integer> {

}
