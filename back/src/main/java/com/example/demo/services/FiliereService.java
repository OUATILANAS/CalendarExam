package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDao;
import com.example.demo.models.Filiere;
import com.example.demo.repository.FiliereRepository;

@Service
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
	public void update(Filiere p) {
		 filiereRepository.save(p);
	}

	@Override
	public void delete(Filiere p) {
		filiereRepository.delete(p);
		
	}

	@Override
	public Filiere findById(int id) {
		
		return filiereRepository.findById(id);
	}

	
	

}
