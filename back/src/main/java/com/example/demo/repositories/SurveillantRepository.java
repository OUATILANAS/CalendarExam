package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Surveillant;

public interface SurveillantRepository extends JpaRepository<Surveillant, Integer>{
	
	Surveillant findById(int id);
	Surveillant findByMatricule(String matricule);
	
}