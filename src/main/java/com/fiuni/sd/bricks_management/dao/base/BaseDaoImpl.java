package com.fiuni.sd.bricks_management.dao.base;

import java.util.ArrayList;

import com.fiuni.sd.bricks_management.domain.base.BaseDomain;

public abstract class BaseDaoImpl <D extends BaseDomain> implements IBaseDao<D> {
	protected BaseDaoImpl() {}
	
	protected static <T> ArrayList<T> safeConversion(Iterable<?> prevArray, Class<T> listClass) {
		ArrayList<T> arr = new ArrayList<>();
		for (Object item: prevArray) {
			arr.add(listClass.cast(item));
		}
		return arr;
	}
}
