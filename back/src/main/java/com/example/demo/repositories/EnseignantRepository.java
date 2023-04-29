package com.example.demo.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Enseignant;


public interface EnseignantRepository extends JpaRepository<Enseignant, Integer>{
	
	Enseignant findById(int id);
	Enseignant findByMatricule(String matricule);
	
}
