package com.fiuni.sd.bricks_management.service;

import java.util.Collection;

public abstract class BaseService <T> {
	public abstract void create(T object);
	public abstract void update(String id, T object);
	public abstract void delete(String id);
	public abstract Collection<T> get(String id);
	public abstract Collection<T> get();
}
