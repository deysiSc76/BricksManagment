package com.fiuni.sd.bricks_management.service.work;

import com.fiuni.sd.bricks_management.dto.work.WorkDTO;
import com.fiuni.sd.bricks_management.dto.work.WorkResult;
import com.fiuni.sd.bricks_management.service.base.IBaseService;

public interface IWorkService extends IBaseService<WorkDTO,   WorkResult>{

	public void delete(Integer id);

	public WorkDTO update(Integer id, WorkDTO work);

	public WorkResult getByName(String name, Pageable pageable);
}
