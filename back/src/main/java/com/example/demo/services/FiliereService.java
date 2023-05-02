package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.IDao;
import com.example.demo.entities.Filiere;
import com.example.demo.repositories.FiliereRepository;


public class FiliereService implements IDao<Filiere>{
	@Autowired
    private FiliereRepository filiereRepository;

	@Override
	public Filiere save(Filiere p) {
		return filiereRepository.save(p);
	}

	@Override
	public List<Filiere> findAll() {
		 return filiereRepository.findAll();
	}

	@Override
	public Filiere findById(int id) {
		return filiereRepository.findById(id);
	}

	@Override
	public Filiere update(Filiere p) {
		return filiereRepository.save(p);
	}

	@Override
	public void delete(int id) {
		filiereRepository.deleteById(id);
		
	}

	
	

}
