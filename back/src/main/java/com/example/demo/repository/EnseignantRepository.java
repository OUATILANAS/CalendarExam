package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Enseignant;


public interface EnseignantRepository extends JpaRepository<Enseignant, Integer>{
	
	Enseignant findById(int id);
	Enseignant findByMatricule(String matricule);
	
}
