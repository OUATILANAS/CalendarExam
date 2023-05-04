package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Responsable;

public interface ResponsableRepository extends JpaRepository<Responsable, Integer>{
	
	Responsable findById(int id);
	Responsable findByMatricule(String matricule);
	
}
