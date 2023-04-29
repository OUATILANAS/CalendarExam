package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Responsable;
import com.example.demo.repositories.ResponsableRepository;

@Service
public class ResponsableService {
	@Autowired
    private ResponsableRepository responsableRepository;

	
	public Responsable findByMatricule(String matricule) {
		return responsableRepository.findByMatricule(matricule);
	}


	public Responsable save(Responsable p) {
		return responsableRepository.save(p);
	}



	public List<Responsable> findAll() {
		return responsableRepository.findAll();
	}


	
	public Responsable findById(int id) {
		return responsableRepository.findById(id);
	}


	
	public Responsable update(Responsable p) {
		return responsableRepository.save(p);
	}


	
	public void delete(int id) {
		responsableRepository.deleteById(id);
		
	}

}
