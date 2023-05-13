package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDao;
import com.example.demo.models.TypeSalle;
import com.example.demo.repository.TypeSalleRepository;
@Service
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
	public void update(TypeSalle p) {
		 typeSalleRepository.save(p);
	}

	@Override
	public void delete(TypeSalle p) {
		typeSalleRepository.delete(p);
		
	}

}
