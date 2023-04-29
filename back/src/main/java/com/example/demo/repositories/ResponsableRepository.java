package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Responsable;

public interface ResponsableRepository extends JpaRepository<Responsable, Integer>{
	
	Responsable findById(int id);
	Responsable findByMatricule(String matricule);
	
}
