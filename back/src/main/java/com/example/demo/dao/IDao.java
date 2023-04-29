package com.example.demo.dao;

import java.util.List;

public interface IDao <T> {
	T save (T p);
	List<T> findAll();
	T findById(int id);
	public T update(T p);
	void delete(int id);
	
	
}
