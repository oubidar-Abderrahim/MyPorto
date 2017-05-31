package com.dao.generic;

import java.io.Serializable;
import java.util.List;


public interface GenericDAO<T, PK extends Serializable> {

	T findById(PK id);//Order findByID(Long id);
	List<T> findAll();
	T create(T t);
	T update(T t);
	void delete(PK id);
}
