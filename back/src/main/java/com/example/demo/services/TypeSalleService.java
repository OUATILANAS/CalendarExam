package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.IDao;
import com.example.demo.entities.TypeSalle;
import com.example.demo.repositories.TypeSalleRepository;

public class TypeSalleService implements IDao<TypeSalle>{
	@Autowired
    private TypeSalleRepository typeSalleRepository;

	@Override
	public TypeSalle save(TypeSalle p) {
		return typeSalleRepository.save(p);
	}

	@Override
	public List<TypeSalle> findAll() {
		 return typeSalleRepository.findAll();
	}

	@Override
	public TypeSalle findById(int id) {
		return typeSalleRepository.findById(id);
	}

	@Override
	public TypeSalle update(TypeSalle p) {
		return typeSalleRepository.save(p);
	}

	@Override
	public void delete(int id) {
		typeSalleRepository.deleteById(id);
		
	}

}
