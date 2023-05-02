package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Enseignant;
import com.example.demo.repositories.EnseignantRepository;

public class EnseignantService{
	@Autowired
    private EnseignantRepository enseignantRepository;

	
	public Enseignant findByMatricule(String matricule) {
		return enseignantRepository.findByMatricule(matricule);
	}


	public Enseignant save(Enseignant p) {
		return enseignantRepository.save(p);
	}



	public List<Enseignant> findAll() {
		return enseignantRepository.findAll();
	}


	
	public Enseignant findById(int id) {
		return enseignantRepository.findById(id);
	}


	
	public Enseignant update(Enseignant p) {
		return enseignantRepository.save(p);
	}


	
	public void delete(int id) {
		 enseignantRepository.deleteById(id);
		
	}

}
