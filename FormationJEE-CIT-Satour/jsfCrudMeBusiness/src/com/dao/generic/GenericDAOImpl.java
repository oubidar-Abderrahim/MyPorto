package com.dao.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public  abstract class GenericDAOImpl<T, Pk extends Serializable> implements GenericDAO<T, Pk >{

	private Class<T> type;
	
	EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("jsfCrudMeDomain");
	protected EntityManager em = emf.createEntityManager();
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericDAOImpl() {
		
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
	}
	
	@Override
	public T findById(Pk id) {
		return (T) ((EntityManager) this.em).find(type, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return (List<T>) ((EntityManager) em).createQuery("SELECT t from "+ type.getName() + " t").getResultList();
	}

	@Override
	public T create(T t) {
		((EntityManager) this.em).persist(t);
		return t;
	}

	@Override
	public T update(T t) {
		return ((EntityManager) this.em).merge(t);   
	}

	@Override
	public void delete(Pk id) {
		  ((EntityManager) this.em).remove(((EntityManager) this.em).getReference(type, id));
		
	}

	
}
