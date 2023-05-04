package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDAO;
import com.example.demo.models.Filiere;
import com.example.demo.repository.FiliereRepository;

@Service
public class FiliereService implements IDAO<Filiere>{
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
	public void update(Filiere p) {
		 filiereRepository.save(p);
	}

	@Override
	public void delete(Filiere p) {
		filiereRepository.delete(p);
		
	}

	
	

}
