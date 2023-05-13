package com.example.demo.dao;

import java.util.List;

public interface IDao<T> {
	
	T save(T o);
	List<T> findAll();
	T findById(int id);
	void update(T o);
	void delete(T o);
	
	

}
