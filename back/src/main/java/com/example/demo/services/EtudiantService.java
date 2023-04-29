package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Filiere;
import com.example.demo.repositories.EtudiantRepository;


@Service
public class EtudiantService{
	@Autowired
    private EtudiantRepository etudiantRepository;

	
	public List<Etudiant> findAll() {
		return etudiantRepository.findAll();
	}


	public Etudiant findById(int id) {
		
		return etudiantRepository.findById(id);
	}

	
	
	public Etudiant save(Etudiant p) {
		return etudiantRepository.save(p);
	}

	
	public Etudiant update(Etudiant p) {
		return etudiantRepository.save(p);
	}

	

	public Etudiant findByMatricule(String matricule) {
		return etudiantRepository.findByMatricule(matricule);
	}

	
	public void delete(int id) {
		etudiantRepository.deleteById(id);
		
	}
	
	public List<Etudiant> findEtudiantsByFiliere(Filiere filiere) {
        return etudiantRepository.findByFiliere(filiere);
    }

	


}
